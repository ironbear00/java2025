package ch04_ex;
import java.util.*;

public class MonthSchedule
{
	private Day[] days;
	
	public MonthSchedule(int daysCount)
	{
		days=new Day[daysCount];
		for(int i=0; i<daysCount; i++)
		{
			days[i]=new Day();
		}
	}
	
	public void run(Scanner sc)
	{
		boolean isRun=true;
		
		System.out.println("이번달 스케쥴 관리 프로그램.");
		do
		{
			System.out.print("할일(입력:1, 보기:2, 끝내기:3) >>");
			int input=sc.nextInt();
			
			if(input==1)
			{
				input(sc);
			}
			else if(input==2)
			{
				view(sc);
			}
			else if(input==3)
			{
				finish();
				isRun=false;
			}
			else
			{
				System.out.println("제대로 된 숫자를 입력하세요;;");
			}
		}
		while(isRun);
	}
	
	private void input(Scanner sc)
	{		
		System.out.print("날짜(1~30)?");
		int date=sc.nextInt();
		//input check
		if(date<1||date>30)
		{
			System.out.println("1부터 30까지의 날짜를 입력하세요.");
			return;
		}
		//clear the buffer
		sc.nextLine();
		System.out.print("할일(빈칸없이입력)?");
		String work=sc.nextLine();
		days[date-1].set(work);
	}
	
	private void view(Scanner sc)
	{
		System.out.print("날짜(1~30)?");
		int date=sc.nextInt();
		//input check
		if(date<1||date>30)
		{
			System.out.print("1부터 30까지의 날짜를 입력하세요.");
			return;
		}
		System.out.printf("%d일의 할 일은 ", date);
		days[date-1].show();
	}
	
	private void finish()
	{
		System.out.println("프로그램을 종료합니다...");
	}
}
