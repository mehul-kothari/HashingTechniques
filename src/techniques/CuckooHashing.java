package techniques;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CuckooHashing implements HashFunctions {
	
	
	
	int N=128;
	List<Cell> cuckooHash1;
	List<Cell> cuckooHash2;
	CuckooHashing()
	{
		
		cuckooHash1=new ArrayList<Cell>(Collections.nCopies(N, null));
		cuckooHash2=new ArrayList<Cell>(Collections.nCopies(N, null));
	}
	CuckooHashing(int n)
	{
		N=n;
		cuckooHash1=new ArrayList<Cell>(Collections.nCopies(2*N, null));
		cuckooHash2=new ArrayList<Cell>(Collections.nCopies(2*N, null));
		
	}

	@Override
	public int get(int key) {
		int hashedKey1=HashAlgorithm.getHashedValue(key, N);
		int hashedKey2=HashAlgorithm.getHashedValue2(key, N);
		if(cuckooHash1.get(hashedKey1)!=null && cuckooHash1.get(hashedKey1).getCellKey()==key)
			return cuckooHash1.get(hashedKey1).getCellValue();
		if(cuckooHash2.get(hashedKey2)!=null && cuckooHash2.get(hashedKey2).getCellKey()==key)
			return cuckooHash2.get(hashedKey2).getCellValue();
		return Integer.MIN_VALUE;
		// TODO Auto-generated method stub
		//return 0;
	}

	@Override
	public boolean set(int key, int value) {
		int hashedKey1=HashAlgorithm.getHashedValue(key, N);
		int hashedKey2=HashAlgorithm.getHashedValue2(key, N);
		int initialKey=key;
		Cell cell=new Cell(key,value);
		Cell temp=cell;
		int count=0;
		boolean hash=true;
		while(count<3)
		{
			if(temp.getCellKey()==initialKey)
				count++;
			if(hash)
			{
				hash=false;
			if(cuckooHash1.get(hashedKey1)!=null)
			{
				if(cuckooHash1.get(hashedKey1).getCellKey()!=temp.getCellKey())
				{
				hashedKey2=HashAlgorithm.getHashedValue2(cuckooHash1.get(hashedKey1).getCellKey(),N);
				Cell temp1=cuckooHash1.get(hashedKey1);
				cuckooHash1.set(hashedKey1, temp);
				temp=temp1;
				}
				else
				{
					cuckooHash1.get(hashedKey1).setCellValue(value);
					return true;
				}
				
			}
			else
			{
				cuckooHash1.set(hashedKey1, temp);
				return true;
			}
			}
			else
			{
				hash=true;
				if(cuckooHash2.get(hashedKey2)!=null)
				{
					
					hashedKey1=HashAlgorithm.getHashedValue(cuckooHash2.get(hashedKey2).getCellKey(),N);
					Cell temp1=cuckooHash2.get(hashedKey2);
					cuckooHash2.set(hashedKey2, temp);
					temp=temp1;
					
				}
				else
				{
					cuckooHash2.set(hashedKey2, temp);
					return true;
				}
				
				
			}
				
			
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int key) {
		int hashedKey1=HashAlgorithm.getHashedValue(key, N);
		int hashedKey2=HashAlgorithm.getHashedValue2(key, N);
		if(cuckooHash1.get(hashedKey1)!=null && cuckooHash1.get(hashedKey1).getCellKey()==key)
		{
			cuckooHash1.set(hashedKey1, null);
			return true;
		}
		if(cuckooHash2.get(hashedKey2)!=null && cuckooHash2.get(hashedKey2).getCellKey()==key)
		{
			cuckooHash2.set(hashedKey2, null);
			return true;
		}
		
		// TODO Auto-generated method stub
		return false;
	}

}
