package techniques;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HashChaining implements HashFunctions {
	
	
	int N=128;
	List<Cell> hashChain;
	HashChaining()
	{
		
		hashChain=new ArrayList<Cell>(Collections.nCopies(N, null));
	}
	HashChaining(int n)
	{
		N=n;
		hashChain=new ArrayList<Cell>(Collections.nCopies(2*N, null));
		
		
	}

	@Override
	public int get(int key) {
		int hashedKey=HashAlgorithm.getHashedValue(key, N);
		if(hashChain.get(hashedKey)!=null)
		{
			Cell temp=hashChain.get(hashedKey);
			while(temp!=null && temp.getCellKey()!=key)
			{
				temp=temp.next;
			}
			if(temp!=null)
				return temp.getCellValue();
		}
		return Integer.MIN_VALUE;
		// TODO Auto-generated method stub
		//return 0;
	}

	@Override
	public boolean set(int key, int value) {
		int hashedKey=HashAlgorithm.getHashedValue(key, N);
		if(hashChain.get(hashedKey)!=null)
		{
			Cell temp=hashChain.get(hashedKey);
			while(temp.next!=null && temp.getCellKey()!=key)
			{
				temp=temp.next;
			}
			if(temp.getCellKey()==key)
			{
				temp.setCellValue(value);
			}
			else
			{
				Cell cell=new Cell(key,value);
				temp.next=cell;
				
			}
			
		}
		else
		{
			Cell cell=new Cell(key,value);
			hashChain.set(hashedKey, cell);
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int key) {
		int hashedKey=HashAlgorithm.getHashedValue(key, N);
		if(hashChain.get(hashedKey)!=null)
		{
			Cell temp=hashChain.get(hashedKey);
			if(temp.getCellKey()==key)
			{
				hashChain.set(hashedKey, temp.next);
				return true;
				
			}
			while(temp.next!=null && temp.next.getCellKey()!=key)
			{
				temp=temp.next;
			}
			if(temp.next!=null)
			{
				Cell toDelete=temp.next;
				temp.next=toDelete.next;
				toDelete.next=null;
				return true;
			}
		}
		// TODO Auto-generated method stub
		return false;
	}

}
