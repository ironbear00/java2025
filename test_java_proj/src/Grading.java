import java.util.Scanner;

public class Grading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char grade;
		Scanner scanner=new Scanner(System.in);
		
		System.out.print("점수를 입력하세요.(0~100)");
		int score=scanner.nextInt();
		
		System.out.print("학년을 입력하세요.(1~4)");
		int year=scanner.nextInt();
		
		if(score>=60)
		{
			if(year!=4)
			{
				System.out.println("합격!");
			}
			else if(score >= 70)
			{
				System.out.println("합격!");
			}
			else
			{
				System.out.println("불합격!");
			}
		}
		else
		{
			System.out.println("불합격!");
		}
		
		if(score>=90)
		{
			grade='A';
		}
		else if(score>=80 && score<90)
		{
			grade='B';
		}
		else if(score>=70&& score<80)
		{
			grade='C';
		}
		else if(score>=60)
		{
			grade='D';
		}
		else
		{
			grade='F';
		}
		
		
		System.out.println("학점은 "+grade+"입니다.");
		scanner.close();
		
	}

}
