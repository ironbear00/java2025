import java.util.Arrays;
import java.util.Scanner;

public class chapter_2_java_basic 
{

	public static void main(String[] args) 
	{
		//create the scanner once
		Scanner scanner=new Scanner(System.in);
		
		//run functions here down below
		//
		//AddCalculator(scanner);
		//BuildingHeight(scanner);
		//FunctionCalculator(scanner);
		//ANDORCalculator(scanner);
		
		// [----practices----]
		//
		//WonToDol(scanner);
		//SameTen(scanner);
		//CoinsAndDol(scanner);
		//Sorting(scanner);
		//IsTriangle(scanner);
		//ThreeSixNine(scanner);
		//WhereIsTheSquare(scanner);
		//IsSquareCollapse(scanner);
		//IsCircleIn(scanner);
		//IsCircleCollapse(scanner);
		Seasons(scanner);
		Calculator(scanner);
		
		//close the scanner          
		scanner.close();
	}
	
	public static void AddCalculator(Scanner scanner)
	{	
		int num1, num2, sum=0;
		
		System.out.print("두 정수를 입력하세요>>");
		num1=scanner.nextInt();
		num2=scanner.nextInt();
		
		sum=num1+num2;
				
		System.out.println(num1+"+"+num2+"은"+sum);
	}
	
	public static void BuildingHeight(Scanner scanner)
	{
		int floor, height=0;
		
		System.out.print("몇 층인지 입력하세용>>");
		floor=scanner.nextInt();
		
		height=floor*5;
		
		System.out.println(height+"m 입니다.");
	}
	
	public static void FunctionCalculator(Scanner scanner)
	{
		int x, y=0;
		
		System.out.print("x 값을 입력하세용>>");
		x=scanner.nextInt();
		
		y=x*x-3*x+7;
		
		System.out.print("x="+x+", y="+y);
	}

	// [----practice #7----]
	public static void WhereIsTheSquare(Scanner scanner)
	{
		int x, y;
		
		System.out.print("점 (x, y)의 좌표를 입력하세욧>>");
		x=scanner.nextInt();
		y=scanner.nextInt();
		
		if(x>50 && x<100)
		{
			if(y>50 && y<100)
			{
				System.out.print("점("+x+","+y+")은 (50, 50)과 (100, 100)의 사각형 내에 있습니다.");	
			}
		}
		else
		{
			System.out.print("점("+x+","+y+")은 (50, 50)과 (100, 100)의 사각형 외에 있습니다.");
		}
	}
	
	public static void ANDORCalculator(Scanner scanner)
	{	
		System.out.print("논리 연산을 입력하세요>>");
		String var=scanner.nextLine();
		
		switch(var)
		{
			case "true OR false":
				System.out.print("false");
				break;
			case "true AND false":
				System.out.print("true");
				break;
				
			default:
				System.out.print("어허..!");
				
		}
	}
	
	// [----practice #1----]
	public static void WonToDol(Scanner scanner)
	{
		int won=0;
		float dol=0;
		final int RATE=1216;
		
		System.out.print("원화를 입력하세요(단위 원)>>");
		won=scanner.nextInt();
		
		dol=(float)won/RATE;
		
		System.out.printf("%d원은 $%.2f입니다.", won, dol);
	}
	
	// [----practice #2----]
	public static void SameTen(Scanner scanner)
	{	
		System.out.print("두 자리 정수 입력(10~99)>>");
		int input_1=scanner.nextInt();
		
		//exception case
		if(input_1<10 || input_1>100)
		{
			System.out.println("두 자리 정수를 입력하세욧!!");
			//call the function again
			SameTen(scanner);
			return;	
		}
		
		int ten=input_1/10;
		int one=input_1%10;
		
		if(ten==one)
		{
			System.out.print("Yes! 10의 자리와 1의 자리가 같습니다.");
		}
		else
		{
			System.out.print("No! 10의 자리와 1의 자리가 다릅니다.");
		}
	}
	
	// [----practice #3----]
	public static void CoinsAndDol(Scanner scanner)
	{
		int fiveMan, oneMan, thou, fiveHun, hun, fiveTen, ten;
		
		System.out.print("금액을 입력하시오>>");
		int input=scanner.nextInt();
		
		fiveMan=input/50000;
		input-=(fiveMan*50000);
		
		oneMan=input/10000;
		input-=(oneMan*10000);
		
		thou=input/1000;
		input-=(thou*1000);
		
		fiveHun=input/500;
		input-=(fiveHun*500);
		
		hun=input/100;
		input-=(hun*100);
		
		fiveTen=input/50;
		input-=(fiveTen*50);
		
		ten=input/10;
		input-=(ten*10);
		
		System.out.println("오만원권 "+fiveMan+"매");
		System.out.println("만원권 "+oneMan+"매");
		System.out.println("천원권 "+thou+"매");
		System.out.println("오백원 "+fiveHun+"개");
		System.out.println("백원 "+hun+"개");
		System.out.println("오십원 "+fiveTen+"개");
		System.out.println("십원 "+ten+"개");
	}
	
	// [----practice #4----]
	//bubble sorting
	//change to react more than three values
	public static void Sorting(Scanner scanner)
	{
		int[] arr=new int[3];

		System.out.print("정수 3개 입력 ");
		
		arr[0]=scanner.nextInt();
		arr[1]=scanner.nextInt();
		arr[2]=scanner.nextInt();
		
		for(int i=0; i<2; i++)
		{
			for(int j=0; j<2-i; j++) 
			{   
		        if(arr[j] > arr[j+1]) 
		        {
		            int temp = arr[j];
		            
		            arr[j] = arr[j+1];
		            arr[j+1] = temp;
		        }
		    }
		}
			
		System.out.print("중간 값은 "+arr[1]);
	}
	
	// [----practice #5----]
	public static void IsTriangle(Scanner scanner)
	{
		boolean isTriangle=false;
		int[] arr=new int[3];

		System.out.print("삼각형이 될 정수 3개 입력 ");
		
		arr[0]=scanner.nextInt();
		arr[1]=scanner.nextInt();
		arr[2]=scanner.nextInt();
		
		//sorting
		Arrays.sort(arr);

		if(arr[0]+arr[1]>arr[2])
		{
			isTriangle=true;
		}
		
		if(isTriangle)
		{
			System.out.print("삼각형이 됩니다.");
		}
		else
		{
			System.out.print("삼각형이 안됩니다.");
		}
	}
	
	// [----practice #6----]
	public static void ThreeSixNine(Scanner scanner)

	{
		System.out.print("1~99 사이의 정수를 입력하시오>>");
		int input=scanner.nextInt();
		
		//exception case
		if(input<1 || input>99)
		{
			System.out.println("1~99 사이의 정수를 입력하세욧!!");
			//call the function again
			ThreeSixNine(scanner);
			return;	
		}				
		
		int num1=input/10;
		int num2=input%10;
		
		if(num1==3 || num1==6|| num1==9)
		{
			if(num2==3|| num2==6||num2==9)
			{
				System.out.println("박수짝짝!");
			}
			else
			{
				System.out.println("박수짝");
			}
		}
		if(num2==3|| num2==6||num2==9)
		{
			if(num1==3|| num1==6||num1==9)
			{
				//System.out.println("박수짝짝!");
				ThreeSixNine(scanner);
				return;
			}
			else
			{
				System.out.println("박수짝");
			}
		}
		
		ThreeSixNine(scanner);
	}
	
	// [----practice #8----]
	public static void IsSquareCollapse(Scanner scanner)
	{
		System.out.print("두 점 (x1, y1), (x2, y2)의 좌표르 입력>>");
		int x1=scanner.nextInt();
		int y1=scanner.nextInt();
		int x2=scanner.nextInt();
		int y2=scanner.nextInt();		
		
		if(inRect(x1, y1, x2, y2))
		{
			System.out.print("사각형이 겹칩니다.");
		}
		else
		{
			System.out.print("사각형이 겹치지 않습니다.");
		}
	}
	
	public static boolean inRect(int x1, int y1, int x2, int y2)
	{
		//one point is in the square
		if((x1>=100 && x1<=200) && (y1>=100 && y1<=200))
		{
			return true;
		}
		else if((x2>=100 && x2<=200) && (y2>=100 && y2<=200))
		{
			return true;
		}
		//the square is in the new square
		else if(x1<100 && y1<100 && x2>200 && y2>200)
		{
			return true;
		}
		//the side of the new square is in the square
		else if((x1>=100 && x1<=200) || (x2>=100 && x2<=200))
		{
			if(y1<100 && y2>200)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else if((y1>=100 && y1<=100)|| (y2>=100 && y2<=200))
		{
			if(x1<100 && y2>200)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	
	// [----practice #9----]
	public static void IsCircleIn(Scanner scanner)
	{
		System.out.print("원의 중심과 반지름 입력>>");
		int input_x=scanner.nextInt();
		int input_y=scanner.nextInt();
		float input_radius=scanner.nextFloat();
		
		System.out.print("점 입력>>");
		int num1=scanner.nextInt();
		int num2=scanner.nextInt();
		
		//change output form ##.#
		if(IsCircleInCalculator(input_x, input_y, num1, num2, input_radius))
		{
			System.out.printf("점 (%d, %d)는 원 안에 있다.", num1, num2);
		}
		else
		{
			System.out.printf("점 (%d, %d)는 원 밖에 있다.", num1, num2);
		}
	}
	
	public static boolean IsCircleInCalculator(int x1, int y1, int x2, int y2, float radius)
	{
		if(Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2))<=radius)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	// [----practice #10----]
	public static void IsCircleCollapse(Scanner scanner)
	{
		System.out.print("첫번째 원의 중심과 반지름 입력>>");
		int x1=scanner.nextInt();
		int y1=scanner.nextInt();
		int radius1=scanner.nextInt();
		
		System.out.print("두번째 원의 중심과 반지름 입력>>");
		int x2=scanner.nextInt();
		int y2=scanner.nextInt();
		int radius2=scanner.nextInt();
		
		double distance;
		
		distance=Math.sqrt(Math.pow((x1-x2), 2)+Math.pow((y1-y2), 2));
		
		
		if(distance<=radius1+radius2)
		{
			System.out.print("두 원은 서로 겹친다.");
		}
		else
		{
			System.out.print("두 원은 서로 겹치지 않는다.");
		}
	}

	// [----practice #11----]
	//how about using enum?
	public static void Seasons(Scanner scanner)
	{
		System.out.print("달을 입력하세요(1~12)>>");
		int month=scanner.nextInt();
		
		//answer(1) using if-else
		if(month==3 || month==4|| month==5)
		{
			System.out.println("봄");
		}
		else if(month==6 || month==7|| month==8)
		{
			System.out.println("여름");
		}
		else if(month==9 || month==10|| month==11)
		{
			System.out.println("가을");
		}
		else if(month==12 || month==1|| month==2)
		{
			System.out.println("겨울");
		}
		else
		{
			System.out.println("나폴리탄 스파게티");
		}
		
		//answer(2) using switch
		switch(month)
		{
			case 3:
			case 4:
			case 5:
				System.out.println("봄");
				break;
			
			case 6:
			case 7:
			case 8:
				System.out.println("여름");
				break;
			
			case 9:
			case 10:
			case 11:
				System.out.println("가을");
				break;
				
			case 12:
			case 1:
			case 2:
				System.out.println("겨울");
				break;
				
			default:
				System.out.println("나폴리탄 스파게티");
				
		}
	}
	
	// [----practice #12----]
	public static void Calculator(Scanner scanner)
	{
		float result=0;
		
		System.out.print("연산>> ");
		float num1=scanner.nextFloat();
		String s=scanner.next();
		float num2=scanner.nextFloat();
		
		//answer(1) using if-else
		if(s.equals("+"))
		{
			result=num1+num2;
		}
		else if(s.equals("-"))
		{
			result=num1-num2;
		}
		else if(s.equals("*"))
		{
			result=num1*num2;
		}
		else if(s.equals("/"))
		{
			if(num2==0)
			{
				System.out.print("0으로 나눌 수 없습니다.");
				return;
			}
			result=num1/num2;
		}
		else
		{
			System.out.print("사칙 연산만 가능합니다.");
			return;
		}
		
		//answer(2) using switch
		switch(s)
		{
			case "+":
				result=num1+num2;
				break;
			case "-":
				result=num1-num2;
				break;
			case "*":
				result=num1*num2;
				break;
			case "/":
				if(num2==0)
				{
					System.out.print("0으로 나눌 수 없습니다.");
					return;
				}
				result=num1/num2;
				break;
				
			default:
				System.out.print("사칙 연산만 가능합니다.");
				return;
		}
		
		System.out.print((int)num1+s+(int)num2+"의 계산 결과는 "+(int)result);
	}
}


// 끝~~~
















