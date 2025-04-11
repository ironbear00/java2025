package swing;
import java.util.*;


class DeleteManager
{
	private Scanner sc=new Scanner(System.in);
	
	public void delete(Person user, int id)
	{
		user.info();
		
		System.out.println(">> 정말 이 레코드를 삭제하겠습니까? (1.Yes 2.No)");
		System.out.print(">> ");
		
		try
		{
			int input=sc.nextInt();
			
			if(input==1)
			{
				UserManager.removeUser(id);
				System.out.printf("id: %d의 레코드가 성공적으로 삭제되었습니다.\n", id);
				UserManager.start();
			}
			else if(input==2)
			{
				UserManager.start();
			}
			else
			{
				UserManager.disable();
				UserManager.start();
			}
		}
		catch(Exception e)
		{
			UserManager.disable();
			UserManager.start();
		}
	}
}
