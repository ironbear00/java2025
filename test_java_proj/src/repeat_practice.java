import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;

public class repeat_practice
{

	public static void main(String[] args)
	{
		Scanner scanner =new Scanner(System.in);

		
		//
		// [----functions are down below----]
		//
		//ForTest();
		//WhileTest(scanner);
		//DoWhileTest();
		//NestedLoop();
		//ContinueTest(scanner);
		//BreakTest(scanner);
		//ArrayAccess(scanner);
		//ArrayLength(scanner);
		//ForeachTest();
		//ScoreAverage();
		//ReturnArray();
		//DivideByZero(scanner);
		//DivideByZeroHandling(scanner);
		InputException(scanner);
		
		scanner.close();
	}
	
	public static void ForTest()
	{
		int sum=0;
		
		for(int i =0; i<=10; i++)
		{
			sum+=i;
			System.out.print(i);
			
			if(i<10)
			{
				System.out.print("+");;
			}
			else
			{
				System.out.print("=");
				System.out.print(sum);
			}
		}
	}
	
	public static void WhileTest(Scanner scanner)

	{
		int count=0;
		int n=0;
		double sum=0;
		
		System.out.println("정수를 입력하고 마지막에 0을 입력하세요.");
		while((n=scanner.nextInt())!=0)
		{
			sum=sum+n;
			count++;
		}
		System.out.print("수의 개수는 "+count+"개이며 ");
		System.out.println("평균은 "+sum/count+"입니다.");
	}

	public static void DoWhileTest()
	{
		char a='a';
		
		do
		{
			System.out.print(a);
			a=(char)(a+1);
		}
		while(a<='z');		
	}

	public static void NestedLoop()
	{
		for(int i=1; i<10; i++)
		{
			for(int j=1; j<10; j++)
			{
				System.out.print(i+" * "+j+" = "+i*j);
				System.out.print('\t');
			}
			System.out.println();
		}
	}

	public static void ContinueTest(Scanner scanner)
	{
		int sum=0;
		
		System.out.println("정수를 5개 입력하세용.");
		
		for(int i=0; i<5; i++)
		{
			int n=scanner.nextInt();
			
			//add positive numbers only
			if(n<=0)
				continue;
			else
				sum+=n;
		}
		System.out.println("양수의 합은 "+sum);
	}
	public static void BreakTest(Scanner scanner)
	{
		System.out.println("exit를 입력하면 종료합니다.");
		
		while(true)
		{
			System.out.print(">>");
			String txt=scanner.nextLine();
			if(txt.equals("exit"))
				break;
		}
		
		System.out.println("종료합니다~~");
	}
	public static void ArrayAccess(Scanner scanner)
	{
		int arr[];
		arr=new int[5];
		int max=0;
		
		System.out.println("양수 5개를 입력하세요.");
		for(int i=0; i<5; i++)
		{
			arr[i]=scanner.nextInt();
			if(arr[i]>max)
			{
				max=arr[i];
			}
		}
		
		System.out.printf("가장 큰 수는 %d 입니다.", max);
	}
	public static void ArrayLength(Scanner scanner)
	{
		int arr[]=new int[5];
		double sum=0.0;
		
		System.out.println("5개의 정수를 입력하세요.");
		
		for(int i=0; i<arr.length; i++)
		{
			arr[i]=scanner.nextInt();
		}
		for(int i=0; i<arr.length; i++)
		{
			sum+=arr[i];
		}
		
		System.out.print("평균은 "+ sum/arr.length);
		
	}
	//for-each test	
	public enum Fruit
	{
		사과,
		배,
		바나나,
		체리,
		딸기,
		포도
	}
	public static void ForeachTest()
	{
		int sum=0;
		
		int[] int_arr={1,2,3,4,5};
		
		Fruit[] fruits=Fruit.values();
		String[] str_arr=new String[fruits.length];
		
		for(int i=0; i<fruits.length; i++)
		{
			str_arr[i]=fruits[i].name();
		}
		
		for(int k:int_arr)
		{
			System.out.print(k+" ");
			sum+=k;
		}
		System.out.println("합은 "+sum);
		
		for( String s:str_arr)
		{
			System.out.print(s+ " ");
		}
	}
	public static void ScoreAverage()
	{
		double score[][]= {{3.3, 3.4},{3.5, 3.6},{3.7, 4.0},{4.1, 4.2}};
		double sum=0;
		
		for(int year=0; year<score.length;year++)
		{
			for(int term=0; term<score[year].length; term++)
			{
				sum+=score[year][term];
			}
		}
		
		int n=score.length;
		int m=score[0].length;
		
		System.out.println("4학년 전체 평점 평균은 "+sum/(n*m));
	}
	//return array test
	public static void ReturnArray()
	{
		int intArr[];
		intArr=createArr();
		
		for(int i=0; i<intArr.length; i++)
		{
			System.out.print(intArr[i]+ " ");
		}
	}
	static int[] createArr()
	{
		int temp[]=new int[4];
		for(int i=0; i<temp.length; i++)
		{
			temp[i]=i;
		}
		return temp;
	}
	//try-catch test
	public static void DivideByZero(Scanner scanner)
	{
		int dividend;
		int divisor;
		
		System.out.print("나뉨수를 입력하쇼>>");
		dividend=scanner.nextInt();
		System.out.print("나눗수를 입력하쇼>>");
		divisor=scanner.nextInt();
		System.out.println(dividend+"를" +divisor+"로 나누면 몫은 "+dividend/divisor+"입니당.");
	}
	public static void DivideByZeroHandling(Scanner scanner)
	{
		int dividend;
		int divisor;
		
		System.out.print("나뉨수를 입력하쇼>>");
		dividend=scanner.nextInt();
		System.out.print("나눗수를 입력하쇼>>");
		divisor=scanner.nextInt();
		
		try
		{
			System.out.println(dividend+"를" +divisor+"로 나누면 몫은 "+dividend/divisor+"입니당.");
		}
		catch(ArithmeticException e)
		{
			System.out.print("0으로 나눌 수 없습니다.");
		}
		finally
		{
			// [----you can close the scanner here.----]
		}

	}
	public static void InputException(Scanner scanner)
	{
		int sum=0;
		int n=0;
		
		System.out.println("정수 3개를 입력하시용>>");
	
		for(int i=0; i<3; i++)
		{
			System.out.print(i+">>");
			try
			{
				n=scanner.nextInt();
			}
			catch(InputMismatchException e)
			{
				System.out.println("정수가 아닙니다. 다시 ㄱㄱ");
				scanner.next();  //delete incorrect value and get value again
				i--;
				continue;
			}
			sum+=n;
		}
		System.out.println("합은 "+sum);
	}

}
























