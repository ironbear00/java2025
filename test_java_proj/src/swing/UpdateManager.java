package swing;
import java.util.*;


public class UpdateManager
{
	private static Scanner sc=new Scanner(System.in);
	
	private Person user;
	private int input_field;
	private int input_id;
	
	public void update(int type)
	{
		switch(type)
		{
			case 1:
				//student
				updateStudent();
				break;
			case 2:
				//professor
				updateProfessor();
				break;
			case 3:
				//staff
				updateStaff();
				break;
			default:
				UserManager.disable();
		}
	}
	
	public void updateStudent()
	{
		System.out.println(">> [ Student ] 레코드 수정을 시작합니다.\n");
	
		input_id=0;
		
		//아이디에 해당하는 person 정보 users에서 가져오기
		//입력 예외처리..
		while(true)
		{
			System.out.print(">> id는 무엇입니까?\n");
			System.out.print(">>\n");
			try
			{
				System.out.print(">> ");
				input_id=sc.nextInt();
				System.out.println();
				//id 중복
				if(!UserManager.users.containsKey(input_id))
				{
					System.out.println(">> 없는 사용자 입니다.\n");
					System.out.println();
				}
				else if(input_id>0)
				{
					break;
				}
				else
				{
					UserManager.disable();
				}
			}
			catch(Exception e)
			{
				UserManager.disable();
			}
		}
		//여기서 person 가져오기	여기서 다운 캐스팅도 해주자..student니까
		user=UserManager.getUser(input_id);
		
		System.out.println("수정할 필드(항목)는 무엇입니까?\n");
		System.out.println("1.name  2.age  3.address  4.grade 5.studentIdNo 6.major\n");
		input_field=0;
		
		while(true)
		{
			try
			{
				System.out.print(">> ");
				input_field=sc.nextInt();
				System.out.println();
				if(input_field>0 && input_field<7)
				{
					break;
				}
				else
				{
					UserManager.disable();
				}
			}
			catch(Exception e)
			{
				UserManager.disable();
			}
		}
		
		//input_field에 해당하는 거 출력..! switch문..ㅈㄴ귀찮네..
		System.out.println("수정할 값을 입력하십시오.\n");
		switch(input_field)
		{
			case 1:
				updateName();
				break;
			case 2:
				updateAge();
				break;
			case 3:
				updateAddress();
				break;
			case 4:
				updateGrade((Student)user);
				break;
			case 5:
				updateStudentIdNo((Student)user);
				break;
			case 6:
				updateMajor((Student)user);
				break;
			default:
				UserManager.disable();
				UserManager.start();
		}
	}
	
	public void updateProfessor()
	{
		System.out.println(">> [ Professor ] 레코드 수정을 시작합니다.\n");
		
		input_id=0;
		
		//아이디에 해당하는 person 정보 users에서 가져오기
		//입력 예외처리..
		while(true)
		{
			System.out.print(">> id는 무엇입니까?\n");
			System.out.print(">>\n");
			try
			{
				System.out.print(">> ");
				input_id=sc.nextInt();
				System.out.println();
				//id 중복
				if(!UserManager.users.containsKey(input_id))
				{
					System.out.println(">> 없는 사용자 입니다.\n");
					System.out.println();
				}
				else if(input_id>0)
				{
					break;
				}
				else
				{
					UserManager.disable();
				}
			}
			catch(Exception e)
			{
				UserManager.disable();
			}
		}
		//여기서 person 가져오기	여기서 다운 캐스팅도 해주자..student니까
		user=UserManager.getUser(input_id);
		
		System.out.println("수정할 필드(항목)는 무엇입니까?\n");
		System.out.println("1.name  2.age  3.address  4.salary 5.position 6.manager 7.major 8.course\n");
		input_field=0;
		
		while(true)
		{
			try
			{
				System.out.print(">> ");
				input_field=sc.nextInt();
				System.out.println();
				if(input_field>0 && input_field<9)
				{
					break;
				}
				else
				{
					UserManager.disable();
				}
			}
			catch(Exception e)
			{
				UserManager.disable();
			}
		}
		
		//input_field에 해당하는 거 출력..! switch문..ㅈㄴ귀찮네..
		System.out.println("수정할 값을 입력하십시오.\n");
		switch(input_field)
		{
			case 1:
				updateName();
				break;
			case 2:
				updateAge();
				break;
			case 3:
				updateAddress();
				break;
			case 4:
				updateSalary((Employee)user);
				break;
			case 5:
				updatePosition((Employee)user);
				break;
			case 6:
				updateSupervisor((Employee)user);
				break;
			case 7:
				updateMajorProf((Professor)user);
				break;
			case 8:
				updateCourse((Professor)user);
				break;
			default:
				UserManager.disable();
				UserManager.start();
		}
	}
	
	public void updateStaff()
	{
		System.out.println(">> [ Staff ] 레코드 수정을 시작합니다.\n");
		
		input_id=0;
		
		//아이디에 해당하는 person 정보 users에서 가져오기
		//입력 예외처리..
		while(true)
		{
			System.out.print(">> id는 무엇입니까?\n");
			System.out.print(">>\n");
			try
			{
				System.out.print(">> ");
				input_id=sc.nextInt();
				System.out.println();
				//id 중복
				if(!UserManager.users.containsKey(input_id))
				{
					System.out.println(">> 없는 사용자 입니다.\n");
					System.out.println();
				}
				else if(input_id>0)
				{
					break;
				}
				else
				{
					UserManager.disable();
				}
			}
			catch(Exception e)
			{
				UserManager.disable();
			}
		}
		//여기서 person 가져오기	여기서 다운 캐스팅도 해주자..
		user=UserManager.getUser(input_id);
		
		System.out.println("수정할 필드(항목)는 무엇입니까?\n");
		System.out.println("1.name  2.age  3.address  4.salary 5.position 6.manager 7.department\n");
		input_field=0;
		
		while(true)
		{
			try
			{
				System.out.print(">> ");
				input_field=sc.nextInt();
				System.out.println();
				if(input_field>0 && input_field<8)
				{
					break;
				}
				else
				{
					UserManager.disable();
				}
			}
			catch(Exception e)
			{
				UserManager.disable();
			}
		}
		
		//input_field에 해당하는 거 출력..! switch문..ㅈㄴ귀찮네..
		System.out.println(">> 수정할 값을 입력하십시오.\n");
		switch(input_field)
		{
			case 1:
				updateName();
				break;
			case 2:
				updateAge();
				break;
			case 3:
				updateAddress();
				break;
			case 4:
				updateSalary((Employee)user);
				break;
			case 5:
				updatePosition((Employee)user);
				break;
			case 6:
				updateSupervisor((Employee)user);
				break;
			case 7:
				updateDepartment((Staff)user);
				break;
			default:
				UserManager.disable();
				UserManager.start();
		}
	}

	
	
	
	public void updateName()
	{
		System.out.println(">> name:\n");
		System.out.print(">> ");
		String n_name=sc.next();
		
		user.setName(n_name);
		
		UserManager.showUpdate(input_id);
		System.out.printf("id: %d의 name이 성공적으로 수정되었습니다.\n", input_id);
		UserManager.start();
	}
	
	public void updateAge()
	{
		System.out.println(">> age:\n");
		System.out.print(">> ");
		int n_age=sc.nextInt();
		
		user.setAge(n_age);
		
		UserManager.showUpdate(input_id);
		System.out.printf("id: %d의 Age가 성공적으로 수정되었습니다.\n", input_id);
		UserManager.start();
	}
	
	public void updateAddress()
	{
		sc.nextLine();
		System.out.println(">> address:\n");
		System.out.print(">> ");
		String n_address=sc.nextLine();
	
		user.setAddress(n_address);

		UserManager.showUpdate(input_id);
		System.out.printf("id: %d의 address가 성공적으로 수정되었습니다.\n", input_id);
		UserManager.start();
	}
	
	//student only
	public void updateGrade(Student student)
	{
		System.out.println(">> grade:\n");
		System.out.print(">> ");
		int n_grade=sc.nextInt();

		student.setGrade(n_grade);
		
		UserManager.showUpdate(input_id);
		System.out.printf("id: %d의 grade가 성공적으로 수정되었습니다.\n", input_id);
		UserManager.start();
	}
	
	public void updateStudentIdNo(Student student)
	{
		System.out.println(">> studentIdNo:\n");
		System.out.print(">> ");
		int n_studentIdNo=sc.nextInt();
		
		student.setStudentIdNo(n_studentIdNo);
		
		UserManager.showUpdate(input_id);
		System.out.printf("id: %d의 studentIdNo가 성공적으로 수정되었습니다.\n", input_id);
		UserManager.start();
	}
	
	public void updateMajor(Student student)
	{
		System.out.println(">> major:\n");
		System.out.print(">> ");
		String n_major=sc.next();
		
		student.setMajor(n_major);
		
		UserManager.showUpdate(input_id);
		System.out.printf("id: %d의 major가 성공적으로 수정되었습니다.\n", input_id);
		UserManager.start();
	}
	
	//common employee
	public void updateSalary(Employee employee)
	{
		System.out.println(">> salary:\n");
		System.out.print(">> ");
		int n_salary=sc.nextInt();

		employee.setSalary(n_salary);
		
		UserManager.showUpdate(input_id);
		System.out.printf("id: %d의 salary가 성공적으로 수정되었습니다.\n", input_id);
		UserManager.start();
	}
	
	public void updatePosition(Employee employee)
	{
		System.out.println(">> position:\n");
		System.out.print(">> ");
		String n_position=sc.next();

		employee.setPosition(n_position);
		
		UserManager.showUpdate(input_id);
		System.out.printf("id: %d의 position이 성공적으로 수정되었습니다.\n", input_id);
		UserManager.start();
	}

	public void updateSupervisor(Employee employee)
	{
		System.out.println(">> manager:\n");
		System.out.print(">> ");
		int manager_id=sc.nextInt();

		Person manager_person=UserManager.getUser(manager_id);
		
		if(manager_person instanceof Employee)
		{
			Employee n_manager=(Employee)manager_person;
			employee.setManager(n_manager);
		}
		else
		{
			UserManager.disable();
		}
		
		UserManager.showUpdate(input_id);
		System.out.printf("id: %d의 Manager가 성공적으로 수정되었습니다.\n", input_id);
		UserManager.start();
	}
	
	//professor only
	public void updateCourse(Professor professor)
	{
		System.out.println(">> course:\n");
		System.out.print(">> ");
		String n_course=sc.next();

		professor.setPosition(n_course);
		
		UserManager.showUpdate(input_id);
		System.out.printf("id: %d의 course가 성공적으로 수정되었습니다.\n", input_id);
		UserManager.start();
	}
	
	public void updateMajorProf(Professor professor)
	{
		System.out.println(">> Major:\n");
		System.out.print(">> ");
		String n_major=sc.next();

		professor.setMajor(n_major);
		
		UserManager.showUpdate(input_id);
		System.out.printf("id: %d의 major가 성공적으로 수정되었습니다.\n", input_id);
		UserManager.start();
	}
	
	//staff only
	public void updateDepartment(Staff staff)
	{
		System.out.println(">> department:\n");
		System.out.print(">> ");
		String n_department=sc.next();

		staff.setDepartment(n_department);
		
		UserManager.showUpdate(input_id);
		System.out.printf("id: %d의 department가 성공적으로 수정되었습니다.\n", input_id);
		UserManager.start();
	}
	
	























}


