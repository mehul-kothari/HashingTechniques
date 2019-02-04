package techniques;

public class HashAlgorithm {
	
	public static int getHashedValue(int key, int N)
	{
		return key%N;
		
	}

	public static int getHashedValue2(int key, int N) {
		// TODO Auto-generated method stub
		return (key/N)%N;
	}

}
