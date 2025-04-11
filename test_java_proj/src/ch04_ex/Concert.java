package ch04_ex;
import java.util.*;

public class Concert
{
	private boolean isRun=true;
	private Seat[] s=new Seat[10];
	private Seat[] a=new Seat[10];
	private Seat[] b=new Seat[10];
	
	//create seats
	public void concert()
	{
		for(int i=0; i<s.length; i++)
		{
			s[i]=new Seat();
			a[i]=new Seat();
			b[i]=new Seat();
		}	
	}
	
	public void run(Scanner sc)
	{
		do
		{
			System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4>>");
			int input=sc.nextInt();
		
			switch(input)
			{
				case 1:
					book(sc);
					break;
				case 2:
					viewAll();
					break;
				case 3:
					cancel(sc);
					break;
				case 4:
					isRun=false;
					break;
				default:
					System.out.println("<<<잘못 입력하였습니다.>>>");
					break;
			}
		}
		while(isRun);
		
		System.out.print("<<<조회를 종료하였습니다.>>>");
	}
	
	private void book(Scanner sc)
	{
		System.out.print("좌석구분 S(1), A(2), B(3)>>");
		int seat_Type=sc.nextInt();
		if(seat_Type!=1 && seat_Type!=2 && seat_Type!=3)
		{
			System.out.println("<<<잘못 입력하였습니다.>>>");
			return;
		}
		
		switch(seat_Type)
		{
			case 1:
				view(seat_Type);
				book_next(sc, seat_Type);
				break;
			case 2:
				view(seat_Type);
				book_next(sc, seat_Type);
				break;
			case 3:
				view(seat_Type);
				book_next(sc, seat_Type);
				break;
			default:
				System.out.println("<<<잘못 입력하였습니다.>>>");
				break;
		}
	}
	
	private void book_next(Scanner sc, int type)
	{
		System.out.print("이름>>");
		String name=sc.next();
		System.out.print("번호>>");
		int num=sc.nextInt();
		if(!(num>=1 && num<=10))
		{
			System.out.println("<<<잘못 입력하였습니다.>>>");
			return;
		}
		
		if(type==1)
		{
			s[num-1].setName(name);	
		}
		else if(type==2)
		{
			a[num-1].setName(name);	
		}
		else if(type==3)
		{
			b[num-1].setName(name);	
		}
	}
	
	private void viewAll()
	{
		view(1);
		view(2);
		view(3);
		System.out.println("<<<조회를 완료하였습니다.>>>");
	}
	
	private void view(int type)
	{
		//s
		if(type==1)
		{
			System.out.print("S>> ");
			for(int i=0; i<s.length; i++)
			{
				s[i].show();
			}
			System.out.println();
		}
		//a
		else if(type==2)
		{
			System.out.print("A>> ");
			for(int i=0; i<a.length; i++)
			{
				a[i].show();
			}
			System.out.println();
		}
		//b
		else if(type==3)
		{
			System.out.print("B>> ");
			for(int i=0; i<b.length; i++)
			{
				b[i].show();
			}
			System.out.println();
		}
	}
	
	private void cancel(Scanner sc)
	{
		System.out.print("좌석구분 S(1), A(2), B(3)>>");
		int seat_Type=sc.nextInt();
		if(seat_Type!=1 && seat_Type!=2 && seat_Type!=3)
		{
			System.out.println("<<<잘못 입력하였습니다.>>>");
			return;
		}
		
		switch(seat_Type)
		{
			case 1:
				view(seat_Type);
				cancel_next(sc, seat_Type);
				break;
			case 2:
				view(seat_Type);
				cancel_next(sc, seat_Type);
				break;
			case 3:
				view(seat_Type);
				cancel_next(sc, seat_Type);
				break;
			default:
				System.out.println("<<<잘못 입력하였습니다.>>>");
				break;
		}
	}
	
	private void cancel_next(Scanner sc, int type)
	{
		System.out.print("이름>>");
		String name=sc.next();
		
		if(type==1)
		{
			for(int i=0; i<s.length; i++)
			{
				if(name.equals(s[i].getName()))
				{
					s[i].setName(null);
				}
			}
		}
		else if(type==2)
		{
			for(int i=0; i<a.length; i++)
			{
				if(name.equals(a[i].getName()))
				{
					a[i].setName(null);
				}
			}	
		}
		else if(type==3)
		{
			for(int i=0; i<b.length; i++)
			{
				if(name.equals(b[i].getName()))
				{
					b[i].setName(null);
				}
			}	
		}
	}
}
