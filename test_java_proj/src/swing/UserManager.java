package swing;
import java.util.*;


class UserManager
{
	private static InsertManager insert_manager;
	private static UpdateManager update_manager;
	private static ExitManager exit_manager;
	private static DeleteManager delete_manager;
	private static FileManager file_manager;
	
	private static Scanner sc=new Scanner(System.in);
	
	protected static Map<Integer, Person> users;
	
	
	public static void init() 
	{
        if (users == null) users = new HashMap<>();
    }
	
	public static void main(String[] args)
	{
		if(insert_manager==null) insert_manager=new InsertManager();	
		if(update_manager==null) update_manager=new UpdateManager();
		if(exit_manager==null) exit_manager=new ExitManager();
		if(delete_manager==null) delete_manager= new DeleteManager();
		if(file_manager==null) file_manager=new FileManager();
	
		ImportController import_controller=new ImportController();
		
		users=new HashMap<>();
		import_controller.importUserData("C:\\Users\\it\\eclipse-workspace-se\\test_java_proj\\input.txt");
		start();
		
		sc.close();
	}
	
	public static void start()
	{
		int input=0;
		
		while(true)
		{
			System.out.println("\n1.추가  2.수정  3.삭제  4.출력 5.종료\n");
			System.out.print(">>어떤 작업을 수행하시겠습니까? ... ");
			try
			{
				input=sc.nextInt();
				System.out.println();
				if(input>0 && input<6)
				{
					break;
				}
				else
				{
					disable();
				}
			}
			catch(Exception e)
			{
				disable();
			}
		}
		
		switch(input)
		{
			case 1:
				insert();
				break;
			case 2:
				update();
				break;
			case 3:
				delete();
				break;
			case 4:
				show();
				break;
			case 5:
				exit();
				break;
			default:
				disable();
		}
	}
	
	public static void insert()
	{
		int input=0;
		
		while(true)
		{
			System.out.println(">> 어떤 형식의 레코드를 추가할 것입니까?\n");
			System.out.println(">> 1.Student 2.Professor 3.Staff\n");
			try
			{
				System.out.print(">> ");
				input=sc.nextInt();
				System.out.println();
				if(input>0 && input<4)
				{
					break;
				}
				else
				{
					disable();
				}
			}
			catch(Exception e)
			{
				disable();
			}
		}
		
		insert_manager.insert(input);
	}
	
	public static void update()
	{
		int input=0;
		
		while(true)
		{
			System.out.println(">> 어떤 레코드를 수정하시겠습니까?\n");
			System.out.println(">> 1.Student 2.Professor 3.Staff\n");
			try
			{
				System.out.print(">> ");
				input=sc.nextInt();
				System.out.println();
				if(input>0 && input<4)
				{
					break;
				}
				else
				{
					disable();
				}
			}
			catch(Exception e)
			{
				disable();
			}
		}
		
		update_manager.update(input);
	}

	public static void delete()
	{
		System.out.println(">> 삭제를 원하는 id를 입력 하십시오 ... ");
		int id=sc.nextInt();
		Person user=users.get(id);
		if(user!=null)
		{
			//user.info();
			delete_manager.delete(user, id);
		}
		else
		{
			System.out.print("\n>> 없는 사용자 입니다.");
			System.out.println();
			sc.nextLine();
			start();
		}
	}
	
	public static void show()
	{
		int input=0;
		
		System.out.println(">> 1.파일출력 2.콘솔 출력\n");
		System.out.print(">> ");
		input=sc.nextInt();
		if(input==1)
		{
			file_manager.exportFile();
		}
		else if(input==2)
		{
			exit_manager.showAll();
		}
		else
		{
			disable();
			start();
		}
	}
	
	public static void exit()
	{
		int input=0;
		
		System.out.println(">> 정말 끝내시겠습니까?(1.Yes 2.No) [파일 출력했는지 확인!]\n");
		System.out.print(">> ");
		input=sc.nextInt();
		if(input==1)
		{
			exit_manager.exitProgram();
		}
		else if(input==2)
		{
			start();
		}
		else
		{
			disable();
			start();
		}
		
	}

	public static void disable()
	{
		System.out.println("수행할 수 없는 작업니다.\n");
		sc.nextLine();
	}

	public static void addUser(int id, Person user)
	{
		users.put(id, user);
	}
	
	public static Person getUser(int id)
	{
		return users.get(id);
	}
	
	public static Map<Integer, Person> getAllUsers()
	{
		return users;
	}
	
	public static void showUpdate(int id)
	{
		Person user=users.get(id);
		if(user!=null)
		{
			user.info();
		}
	}
	
	public static void removeUser(int id)
	{
		users.remove(id);
	}
	
	public static void loadUsers(String filePath)
	{
		file_manager.importFile(filePath);
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

