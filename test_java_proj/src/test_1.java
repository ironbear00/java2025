import java.util.Scanner;

public class test_1 {

	public static void main(String[] args)
	{
		Scanner scanner=new Scanner(System.in);
		
		System.out.print("가위 바위 보 게임입니다. 가위, 바위, 보 중에서 입력하세요.\n");
		System.out.print("철수 >>");
		String player1=scanner.next();
		System.out.print("영희 >>");
		String player2=scanner.next();
		
		scanner.close();
		
		if(player1.equals(player2))
		{
			System.out.print("비겼습니다.");
		}
		else
		{
			if(player1.equals("가위"))
			{
				if(player2.equals("바위"))
				{
					System.out.print("영희가 이겼습니다.");
				}
				else if(player2.equals("보"))
				{
					System.out.print("철수가 이겼습니다.");
				}
			}
			else if(player1.equals("바위"))
			{
				if(player2.equals("보"))
				{
					System.out.print("영희가 이겼습니다.");
				}
				else if(player2.equals("가위"))
				{
					System.out.print("철수가 이겼습니다.");
				}
			}
			else if(player1.equals("보"))
			{
				if(player2.equals("가위"))
				{
					System.out.print("영희가 이겼습니다.");
				}
				else if(player2.equals("바위"))
				{
					System.out.print("철수가 이겼습니다.");
				}
			}
		}
	}
}
