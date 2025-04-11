package ch05_ex;
import java.util.*;

public class Exes
{

	public static void main(String[] args)
	{
		//exOne();
		//exTwo();
		//exThree();
		//exFour();
		//exFive();
		//exSix();
		//exSeven();
		//exEight();
		//exNine();
		//exTen();
		//exEleven();
		//exTwelve();
		exThirteen();
		//exFourteen();
	}
	
	public static void exOne()
	{
		ColorTV myTV=new ColorTV(32, 1024);
		myTV.printProperty();
	}
	
	public static void exTwo()
	{
		IPTV iptv=new IPTV("192.1.1.2", 32, 2048);
		iptv.printProperty();
	}

	public static void exThree()
	{
		WonToDollar toDollar=new WonToDollar(1200);
		toDollar.run();
	}
	
	public static void exFour()
	{
		KmToMile toMile=new KmToMile(1.6);
		toMile.run();
	}

	public static void exFive()
	{
		ColorPoint cp=new ColorPoint(5, 5, "Yellow");
		cp.setXY(10, 20);
		cp.setColor("RED");
		String str=cp.toString();
		System.out.print(str);
	}
	
	public static void exSix()
	{
		ColorPoint zp=new ColorPoint();
		System.out.print(zp.toString());
		System.out.println();
		
		ColorPoint cp=new ColorPoint(10, 10);
		cp.setXY(5, 5);
		cp.setColor("RED");
		System.out.print(cp.toString());
	}
	
	public static void exSeven()
	{
		Point3D p=new Point3D(1,2,3);
		System.out.println(p.toString());
		
		p.moveUp();
		System.out.println(p.toString());
		
		p.moveDown();
		p.move(10, 10);
		System.out.println(p.toString());
		
		p.move(100, 200, 300);
		System.out.println(p.toString());
	}

	public static void exEight()
	{
		PositivePoint p=new PositivePoint();
		p.move(10, 10);
		System.out.println(p.toString());
		
		p.move(-5, 5);
		System.out.println(p.toString());
		
		PositivePoint p2=new PositivePoint(-10, -10);
		System.out.println(p2.toString());
	}

	public static void exNine()
	{
		Scanner sc=new Scanner(System.in);
		int length=0;
		
		//입력 방어 코드
		while(true)
		{
			try
			{
				System.out.print("총 스택 저장 공간의 크기 입력>> ");
				length=sc.nextInt();
				if(length<=0)
				{
					System.out.println("양수만 입력");
					continue;
				}
				break;
			}
			catch(Exception e)
			{
				System.out.println("정수만 입력!");
				sc.nextLine();
			}
		}
		StringStack stk=new StringStack(length);
		
		
		boolean isScanning=true;
		while(isScanning)
		{
			System.out.print("문자열 입력>> ");
			String input=sc.next();
			
			if(input.equals("그만")) break;
			
			if(!stk.push(input))
			{
				System.out.println("stack is full!");
			}
		}
		
		System.out.print("스택에 저장된 모든 문자열 팝! :");
		while(!stk.isEmpty())
		{
			System.out.printf("%s ",stk.pop());
		}
		sc.close();
	}

	public static void exTen()
	{
		Dictionary dic=new Dictionary(10);
		dic.put("손흥민", "축구선수");
		dic.put("아이유", "가수");
		
		System.out.printf("아이유의 값은 %s", dic.get("아이유"));
		System.out.println();
		System.out.printf("손흥민의 값은 %s", dic.get("손흥민"));
		System.out.println();
		
		//갱신
		dic.put("아이유", "배우");
		System.out.printf("아이유의 값은 %s", dic.get("아이유"));
		System.out.println();
		
		//삭제
		dic.delete("손흥민");
		System.out.printf("손흥민의 값은 %s", dic.get("손흥민"));
		System.out.println();
		
		//없는 자료 검색
		System.out.printf("소농민의 값은 %s", dic.get("소농민"));
		System.out.println();
	}

	public static void exEleven()
	{
		Scanner sc=new Scanner(System.in);
		int x=0;
		int y=0;
		int result=0;
		
		Calc calc=null;
		System.out.print("두 정수와 연산자를 입력하시오>>");
		while(true)
		{
			try
			{
				x=sc.nextInt();
				y=sc.nextInt();
				break;
			}
			catch(Exception e)
			{
				System.out.print("숫자!! 숫자만!!");
				sc.nextLine();
			}
		}
		String op=sc.next();
		
		switch(op)
		{
			case "+":
				calc=new Add();
				break;
			case"-":
				calc=new Sub();
				break;
			case"*":
				calc=new Mul();
				break;
			case"/":
				calc=new Div();
				break;
			default:
				System.out.println("제대로 된 연산자를 입력하시소...");
		}
		
		calc.setValue(x, y);
		result=calc.Calculate();
		System.out.println(result);
		sc.close();
	}

	public static void exTwelve()
	{
		Scanner sc=new Scanner(System.in);
		GraphicEditor edit=new GraphicEditor();
		System.out.println("그래픽 에디터 G-v1.0을 실행합니다.");
		edit.start(sc);
		sc.close();
	}
	
	public static void exThirteen()
	{
		Shape2 donut=new Circle2(10);
		donut.redraw();
		System.out.printf("면적은 %.1f", donut.getArea());
	}
	
	public static void exFourteen()
	{
		Shape2[] list=new Shape2[3];
		list[0]=new Circle2(10);
		list[1]=new Oval(20, 30);
		list[2]=new Rect2(20, 30);
		
		for(int i=0; i<list.length; i++)
		{
			list[i].redraw();
		}
		for(int i=0; i<list.length; i++)
		{
			System.out.printf("면적은 %.1f", list[i].getArea());
			System.out.println();
		}
	}
	
	
	

}
