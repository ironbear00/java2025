package ch07.ch07_ex;
import java.util.*;


public class Test
{
	private static Scanner sc=new Scanner(System.in); 
	
	public static void main(String[] args)
	{
		exOne();
		sc.close();
	}
	
	public static void exOne()
	{
		Vector<Double> numbers=new Vector<>();
		
		for(int i=0; i<5; i++)
		{
			double input=sc.nextDouble();
			numbers.add(input);
		}
		Collections.sort(numbers);
		
		System.out.print(numbers.getLast());
	}
}
