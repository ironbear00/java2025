package ch04_ex;
import java.util.*;

public class Exes
{

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		
		//ex01();
		//ex02(sc);
		//ex03();
		//ex04();
		//ex05 and ex06
		//new CircleManager().run(sc);
		//ex07
		//new MonthSchedule(30).run(sc);
		//ex08(sc);
		//ex09();
		ex10(sc);
		//ex11(sc);
		//ex12(sc);
		
		
		sc.close();
	}
	
	//ex01
	public static void ex01()
	{
		TV myTV=new TV("LG", 2020, 32);
		myTV.show();
	}
	
	//ex02
	public static void ex02(Scanner sc)
	{
		System.out.print("수학, 과학, 영어 순으로 3개의 점수 입력>>");
		int math=sc.nextInt();
		int science=sc.nextInt();
		int english=sc.nextInt();
		Grade me =new Grade(math, science, english);
		System.out.printf("평균은 " +me.average());
	}

	//ex03
	public static void ex03()
	{
		Song mySong=new Song("Dancing Queen", "ABBA", 1978, "스웨덴");
		mySong.show();
	}

	//ex04
	//contains check
	public static void ex04()
	{
		Rectangle r=new Rectangle(2, 2, 8, 7);
		Rectangle s=new Rectangle(5, 5, 6, 6);
		Rectangle t=new Rectangle(1, 1, 10, 10);
		
		r.show();
		System.out.println("s의 면적은 "+s.square());
		if(t.contains(r)) System.out.println("t는 r을 포함합니다.");
		if(t.contains(s)) System.out.println("t는 s을 포함합니다.");
	}
	
	//ex08
	public static void ex08(Scanner sc)
	{
		System.out.printf("인원수>> ");
		int count=sc.nextInt();
		new PhoneBook(count).store(sc, count);
	}
	
	//ex09
	public static void ex09()
	{
		int[] arr1= {1,5,6,7,9};
		int[] arr2= {3, 6, -1, 100, 77};
		int[] arr3=ArrayUtil.concat(arr1, arr2);
		ArrayUtil.print(arr3);
	}

	//ex10
	public static void ex10(Scanner sc)
	{
		new DicApp().run(sc);
	}
	
	//ex11
	public static void ex11(Scanner sc)
	{
		Add add=new Add();
		Sub sub=new Sub();
		Mul mul=new Mul();
		Div div=new Div();
		
		System.out.print("두 정수와 연산자를 입력하시오>>");
		int a=sc.nextInt();
		int b=sc.nextInt();
		String op=sc.next();
		
		switch(op) 
		{
			case "+":
				add.setValue(a, b);
				System.out.println(add.Calculate());
				break;
			case "-":
				sub.setValue(a, b);
				System.out.println(sub.Calculate());
				break;
			case "*":
				mul.setValue(a, b);
				System.out.println(mul.Calculate());
				break;
			case "/":
				div.setValue(a, b);
				System.out.println(div.Calculate());
				break;
			default:
				System.out.print("정확하게 입력하세욧!!");
		}
	}
	
	//ex12
	public static void ex12(Scanner sc)
	{
		Concert ct=new Concert();
		ct.concert();
		ct.run(sc);
	}






















}
