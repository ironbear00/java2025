import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class loop_practice
{

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		
		//call functions down below here
		//
		//QuestionOne();
		//QuestionTwo();
		//QuestionThree(sc);
		//QuestionFour(sc);
		//QuestionFive(sc);
		//QuestionSix(sc);
		//QuestionSeven();
		//QuestionEight(sc);
		//QuestionNine();
		//QuestionTen();
		//QuestionThirteen();
		//QuestionFourteen(sc);
		//QuestionFifteen(sc);
		QuestionSixteen(sc);
		
		sc.close();
	}
	
	//fnc1
	public static void QuestionOne()
	{
		int sum=0;

		for(int i=0; i<100; i++)
		{
			if(i%2==0)
			{
				sum=sum+i;
			}
		}
		System.out.println(sum);
	}
	//fnc2
	public static void QuestionTwo()
	{
		int[][] n= {{1}, {1,2,3}, {1}, {1,2,3,4}, {1,2}};
		
		for(int i=0; i<n.length; i++)
		{
			for(int j=0; j<n[i].length; j++)
			{
				System.out.print(n[i][j]+" ");
			}
			System.out.println();
		}
	}
	//fnc3
	public static void QuestionThree(Scanner sc)
	{
		System.out.print("정수를 입력하시오>>");
		int num=sc.nextInt();
	
		for(int i=num; i>0; i--)
		{
			for(int j=0; j<i; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
	//fnc4
	public static void QuestionFour(Scanner sc)
	{
		System.out.println("소문자 알파벳 하나를 입력하시오>>");
		String alp_s=sc.next();
		char alp_c=alp_s.charAt(0);
		
		if(alp_s.length()!=1)
		{
			System.out.print("하나만~");
			return;
		}
		if(alp_c<'a'||alp_c>'z')
		{
			System.out.println("소문자만~");
			return;
		}
		
		//'a'=97
		for(int i=alp_c; i>='a'; i--)
		{
			for(int j='a'; j<=i; j++)
			{
				System.out.print((char)j);
			}
			System.out.println();
		}
	}
	//fnc5
	public static void QuestionFive(Scanner sc)
	{
		System.out.print("양의 정수 10개를 입력하시오>>");
		int[] num_arr=new int[10];
		
		for(int i=0; i<10; i++)
		{
			num_arr[i]=sc.nextInt();
		}
		
		System.out.print("3의 배수는 ");
		for(int i=0; i<num_arr.length; i++)
		{
			if(num_arr[i]%3==0)
			{
				System.out.print(num_arr[i]+" ");
			}
		}
	}
	//fnc6
	public static void QuestionSix(Scanner sc)
	{
		int money=0;
		int fiveMan, man, thou, hund, ten, one=0;
		
		System.out.print("금액을 입력하시오>>");
		money=sc.nextInt();
		
		fiveMan=money/50000;
		money-=fiveMan*50000;
		
		man=money/10000;
		money-=man*10000;
		
		thou=money/1000;
		money-=thou*1000;
		
		hund=money/100;
		money-=hund*100;
		
		ten=money/10;
		money-=ten*10;
		
		one=money;
		
		System.out.println("50000원 짜리 : "+fiveMan+"개");
		System.out.println("10000원 짜리 : "+man+"개");
		System.out.println("1000원 짜리 : "+thou+"개");
		System.out.println("100원 짜리 : "+hund+"개");
		System.out.println("10원 짜리 : "+ten+"개");
		System.out.println("1원 짜리 : "+one+"개");
	}
	//fnc7
	public static void QuestionSeven()
	{
		System.out.print("랜덤한 정수들 : ");
		int[] num_arr=new int[10];
		float sum=0;			
		
		for(int i=0; i<10; i++)
		{
			//num_arr[i]=rand.nextInt(9) + 1;
			num_arr[i]=(int)(Math.random()*10+1);
			System.out.print(num_arr[i]+" ");
			
			sum+=num_arr[i];
		}
		System.out.println();
		System.out.printf("평균은 %.1f", sum/10);
	}
	//fnc8
	public static void QuestionEight(Scanner sc)
	{
		System.out.print("정수 몇 개?");
		int num=sc.nextInt();
		
		if(num<0 || num>100)
		{
			return;
		}
		int[] rand_arr=new int[num];
		
		for (int i = 0; i < num; i++)
		{
            int newNum;
            boolean isDuplicate;

            // 중복되지 않는 랜덤 숫자를 찾을 때까지 반복
            do
            {
                newNum = (int) (Math.random() * 100 + 1);
                isDuplicate = false;

                // 이미 배열에 있는 값들과 비교하여 중복 체크
                for (int j = 0; j < i; j++)
                {
                    if (rand_arr[j] == newNum)
                    {
                        isDuplicate = true;  // 중복이면 다시 랜덤 숫자 생성
                        break;
                    }
                }
            } while (isDuplicate);

            rand_arr[i] = newNum;  // 중복이 없으면 배열에 저장
        }
			//중복 없으면 출력
		for (int i = 0; i < rand_arr.length; i++) 
		{
			//10개씩 줄바꿈
			if(i%10==0 && i!=0) System.out.println();
            System.out.print(rand_arr[i] + " ");
        }		
	}
	//fnc9
	public static void QuestionNine()
	{
		int[][] arr= new int[4][4];
		
		for(int i=0; i<4; i++)
		{
			for(int j=0; j<4; j++)
			{
				arr[i][j]=(int)(Math.random()*10+1);
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	//fnc10
	public static void QuestionTen()
	{
		int[][] arr=new int[4][4];
		int[] rand_num=new int[10];
		
		for(int i=0; i<10; i++)
		{
			rand_num[i]=(int)(Math.random()*10+1);
		}
		
		//랜덤한 위치에 숫자 넣기
		//방문여부 체크
		boolean[] visited=new boolean[16];
		for(int i=0; i<10; i++)
		{
			int pos;
			do
			{
				pos=(int)(Math.random()*16);
			}
			while(visited[pos]); //true -> repeat
			visited[pos]=true;
			
			int row=pos/4;
			int col=pos%4;
			
			arr[row][col]=rand_num[i];
		}
		
		for(int i=0; i<4; i++)
		{
			for(int j=0; j<4; j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	//fnc13
	public static void QuestionThirteen()
	{
		for(int i=0; i<99; i++)
		{
			int num1=i/10;
			int num2=i%10;
			
			if(num1==3 || num1==6|| num1==9)
			{
				if(num2==3|| num2==6||num2==9)
				{
					System.out.println(i+" 박수짝짝!");
				}
				else
				{
					System.out.println(i+" 박수짝");
				}
			}
			if(num2==3|| num2==6||num2==9)
			{
				if(num1==3|| num1==6||num1==9)
				{
					//System.out.println(i+" 박수짝짝!");
					//return;
				}
				else
				{
					System.out.println(i+" 박수짝");
				}
			}
			
		}
	}
	//fnc14
	public enum Course
	{
		JAVA("Java", 95),
		CPP("C++", 88),
		HTML5("HTML5",76),
		COMPUTER("컴퓨터 구조", 62),
		ANDROID("안드로이드", 55);
		
		private final String name;
		private final int score;
		
		Course(String name, int score)
		{
			this.name=name;
			this.score=score;
		}
		
		public String getName()
		{
			return name;
		}
		public int getScore()
		{
			return score;
		}
	}	
	public static void QuestionFourteen(Scanner sc)
	{
		String[] course={Course.JAVA.getName(), Course.CPP.getName(), Course.HTML5.getName(), Course.COMPUTER.getName(), Course.ANDROID.getName()};
		int[] score= {Course.JAVA.getScore(), Course.CPP.getScore(), Course.HTML5.getScore(), Course.COMPUTER.getScore(), Course.ANDROID.getScore()};
		
		String input_course="";
	
		do
		{
			System.out.print("과목 이름>>");
			input_course=sc.next();
			
			//exit condition
			if(input_course.equals("그만"))
			{
				break;
			}
			
			boolean isFound=false;
			
			for(int i=0; i<course.length; i++)
			{
				if(input_course.equals(course[i]))
				{
					System.out.println(course[i]+"의 점수는 "+score[i]);
					isFound=true;
					break;
				}
			}
			if(!isFound)
			{
				System.out.println("없는 과목입니다.");
			}
		}
		while(true);
	}
	//fnc15
	public static void QuestionFifteen(Scanner sc)
	{
		int n1=0;
		int n2=0;
		
		System.out.print("곱하고자 하는 두 수 입력>>");

		for(int i=0; i<2; i++)
		{
			try
			{
				if(i==0)
				{
					n1=sc.nextInt();
				}
				else
				{
					n2=sc.nextInt();
				}
			}
			catch(InputMismatchException e)
			{
				System.out.println("사실은 정수만 입력이 가능하답니다 ㅎㅎ;");
				System.out.print("다시 입력>>");
				sc.nextLine();
				i--;
				continue;
			}
			
		}
		
		System.out.printf("%d x %d = %d", n1, n2, n1*n2);
	}
	//fnc16
	public static void QuestionSixteen(Scanner sc)
	{
		String[] str= {"가위", "바위", "보"};
		
		System.out.println("컴퓨터와 가위 바위 보 게임을 시작합니다.");
		
		do
		{
			System.out.print("가위 바위 보!>>");
			String player=sc.next();
			
			//quit
			if(player.equals("그만"))
			{
				System.out.print("게임을 종료합니다...");
				break;
			}
			
			//exception
			if (!(player.equals("가위") || player.equals("바위") || player.equals("보")))
			{
                System.out.println("손모가지 날라가불라니까;");
                continue;
            }
			
			//choose the computer's
			int rand=(int)(Math.random()*3);
			//draw
			if(str[rand].equals(player))
			{
				System.out.println("사용자 = "+player+" 컴퓨터 = "+str[rand]+", 비겸슴다.");
			}
			else
			{
				System.out.println("사용자 = "+player+" 컴퓨터 = "+str[rand]+", 다시 하세용.");
			}
		}
		while(true);
	}





































}
