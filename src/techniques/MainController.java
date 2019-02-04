package techniques;

import java.util.Scanner;

public class MainController {
	
	public static void main(String args[])
	{
		
		LinearHashing linear=new LinearHashing(200);
		CuckooHashing cuckoo=new CuckooHashing(200);
		CuckooHashing chaining=new CuckooHashing(200);
		TestHashing.testLinear(linear);
		TestHashing.testLinear(cuckoo);
		TestHashing.testLinear(chaining);
		/*Scanner sc=new Scanner(System.in);
		System.out.println("please enter 1 for get, 2 for set and 3 for delete and 4 to stop the program");
		int choice=sc.nextInt();
		while(choice!=4)
		{
			
			if(choice==1)
			{
				System.out.println("Enter key to get value");
				int key=sc.nextInt();
				System.out.println("The value is : " + l.get(key));
			}
			else if(choice==2)
			{
				System.out.println("Enter key and value");
				int key=sc.nextInt();
				int value=sc.nextInt();
				l.set(key, value);
				System.out.println("The value is has been set");
			}
			else
			{
				System.out.println("Enter key to delete");
				int key=sc.nextInt();
				l.delete(key);
				System.out.println("value has been deleted");
				
			}
			System.out.println("please enter 1 for get, 2 for set and 3 for delete and 4 to stop the program");
			choice=sc.nextInt();
		}
		sc.close();*/
	}

}
