package ch04_ex;
import java.util.*;

public class PhoneBook
{
	private Phone[] phones;
	private boolean isSearch=true;
	
	public PhoneBook(int count)
	{
		phones=new Phone[count];
		for(int i=0; i<count; i++)
		{
			phones[i]=new Phone();
		}
	}
	
	public void store(Scanner sc, int count)
	{
		sc.nextLine();
		for(int i=0; i<count; i++)
		{
			System.out.print("이름과 전화번호(이름과 번호는 빈 칸없이 입력)>>");
			String input=sc.nextLine();
			if(!input.contains(" "))
			{
				System.out.print("잘못입력하였습니다. 종료합니다...");
				return;
			}
			String[] parts=input.split(" ");
			phones[i].setName(parts[0]);
			phones[i].setTel(parts[1]);
		}
		System.out.println("저장되었습니다...");
	
		do
		{
			search(sc);
		}
		while(isSearch);
	}
	
	private void search(Scanner sc)
	{
		System.out.print("검색할 이름(종료하려면 '끝')>>");
		String name=sc.next();
		
		if(name.equals("끝")) 
		{
			System.out.print("검색을 종료합니다...");
			isSearch=false;
			return;
		}
		
		for(int i=0; i<phones.length; i++)
		{
			if(name.equals(phones[i].getName()))
			{
				phones[i].show();
			}
		}
	}
}
