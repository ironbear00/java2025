public class Average
{
	public static void main(String[] args)
	{
		if(args.length==0)
		{
			System.out.print("input null");
			return;
		}
		
		//ex11(args);	
		ex12(args);
	}
	
	public static void ex11(String[] args)
	{
		int sum=0;
		for(int i=0; i<args.length; i++)
		{
			sum+=Integer.parseInt(args[i]);
		}
		System.out.print(sum/args.length);
	}
	
	public static void ex12(String[] args)
	{
		int sum=0;
		for(int i=0; i<args.length; i++)
		{
			boolean isInt=false;
			//정수 판별
			try
			{
				Integer.parseInt(args[i]);
				isInt=true;
			}
			catch(NumberFormatException e)
			{
				isInt=false;
			}
			if(isInt)
			{
				sum+=Integer.parseInt(args[i]);
			}
		}
		System.out.print(sum);
	}
}
