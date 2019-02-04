package techniques;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LinearHashing implements HashFunctions{
	
	int N=128;
	List<Cell> linearHash;
	LinearHashing()
	{
		
		linearHash=new ArrayList<Cell>(Collections.nCopies(N, null));
	}
	LinearHashing(int n)
	{
		N=n;
		linearHash=new ArrayList<Cell>(Collections.nCopies(2*N, null));
		
		
	}

	@Override
	public int get(int key) {
		int hashedKey=HashAlgorithm.getHashedValue(key, N);
		while(linearHash.get(hashedKey) !=null && linearHash.get(hashedKey).getCellKey()!=key)
		{
			hashedKey=(hashedKey+1)%N;
		}
		if(linearHash.get(hashedKey) !=null)
			return linearHash.get(hashedKey).getCellValue();
		return Integer.MIN_VALUE;
	}

	@Override
	public boolean set(int key, int value) {
		
		int hashedKey=HashAlgorithm.getHashedValue(key, N);
		while(linearHash.get(hashedKey)!=null)
		{
			if(linearHash.get(hashedKey).getCellKey()==key)
				break;
			hashedKey=(hashedKey+1)%N;
		}
		
		Cell cell=new Cell(key,value);
		linearHash.set(hashedKey, cell);
		return true;
	
	}

	
	//Eager delete
	@Override
	public boolean delete(int key) {
		int hashedKey=HashAlgorithm.getHashedValue(key, N);
		int initialHashedKey=hashedKey;
		while(linearHash.get(hashedKey) !=null && linearHash.get(hashedKey).getCellKey()!=key)
		{
			hashedKey=(hashedKey+1)%N;
		}
		if(linearHash.get(hashedKey) !=null)
		{
			linearHash.set(hashedKey,null);
			int toReplace=hashedKey;
			hashedKey=(hashedKey+1)%N;
			while(linearHash.get(hashedKey) !=null)
			{
				if(linearHash.get(hashedKey).getCellKey()==initialHashedKey)
				{
					linearHash.set(toReplace, linearHash.get(hashedKey));
					linearHash.set(hashedKey, null);
					toReplace=hashedKey;
				}
				hashedKey=(hashedKey+1)%N;
			}
			return true;
			
		}
		
		// TODO Auto-generated method stub
		return false;
	}

}
 