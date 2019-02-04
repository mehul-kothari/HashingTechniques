package techniques;

//import org.apache.commons.lang3.time.StopWatch;

public class TestHashing {
	int SIZE=200;
	public static int testLinear(HashFunctions linearHash)
	{
		System.out.println("testing put method of linear");
		long start=System.nanoTime();
		for(int i=0;i<200;i++)
		{
			linearHash.set(i, i);
		}
		long end=System.nanoTime();
		System.out.println("time taken by put method ---" + (end-start));
		System.out.println("testing get method");
		start=System.nanoTime();
		for(int i=0;i<200;i++)
		{
			int a=linearHash.get(i);
		}
		end=System.nanoTime();
		System.out.println("time taken by get method ---" + (end-start));
		start=System.nanoTime();
		for(int i=0;i<200;i++)
		{
			boolean a=linearHash.delete(i);
		}
		end=System.nanoTime();
		System.out.println("time taken by delete method ---" + (end-start));
		return 0;
		
		
		
	}

}
