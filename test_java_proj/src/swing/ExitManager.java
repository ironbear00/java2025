package swing;
import java.util.*;


public class ExitManager
{
	public void showAll()
	{
		System.out.println(">> 저장된 모든 사용자 정보:\n");

		if (UserManager.users.isEmpty())
		{
			System.out.println(">> 현재 등록된 사용자가 없습니다.\n");
		} 
		else 
		{
			for (Map.Entry<Integer, Person> entry : UserManager.users.entrySet()) 
			{
				int id = entry.getKey();
				Person user = entry.getValue();

				System.out.printf("[ID: %d]\n", id);
				user.info();
				System.out.println(); // 사용자 간 구분
			}
		}
		System.out.println(">> 콘솔에 성공적으로 출력되었습니다!! \n");
		UserManager.start();
	}
	
	public void exitProgram()
	{
		System.out.println(">> 프로그램을 종료합니다.\n");
	}

}
