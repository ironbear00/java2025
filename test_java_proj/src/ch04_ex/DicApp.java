package ch04_ex;
import java.util.*;

public class DicApp
{
	private boolean isSearch=true;
	
	public void run(Scanner sc)
	{
		System.out.println("한영 단어 검색 프로그램입니다.");
		do
		{
			System.out.print("한글 단어?");
			String word=sc.nextLine();
			
			//escape
			if(word.equals("그만"))
			{
				isSearch=false;
				break;
			}
			
			System.out.printf("%s은/는 %s", word, Dictionary.korToEng(word));
			System.out.println();
		}
		while(isSearch);
		
		
		//finish searching
		System.out.print("사전을 덮습니다...");
	}
}
