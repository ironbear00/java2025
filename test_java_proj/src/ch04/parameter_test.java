package ch04;

public class parameter_test
{

	public static void main(String[] args)
	{
		char[] c= {'T','h','i','s',' ','a',' ','P','e','n','c','i','l','.'};
		ArrayParameter_func.printCharArray(c);
		ArrayParameter_func.replaceSpace(c);
		ArrayParameter_func.printCharArray(c);
	}
}