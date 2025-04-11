package ch04_ex;

public class ArrayUtil
{
	public static int[] concat(int[] a, int[] b)
	{
		int[] arr_concat=new int[a.length+b.length];
		for(int i=0; i<a.length; i++)
		{
			arr_concat[i]=a[i];
		}
		for(int i=0; i<b.length; i++)
		{
			arr_concat[i+a.length-1]=b[i];
		}
		return arr_concat;
	}
	
	public static void print(int[] a)
	{
		System.out.print("[ ");
		for(int i=0; i<a.length; i++)
		{
			System.out.printf("%d ", a[i]);
		}
		System.out.print("]");
	}
}
