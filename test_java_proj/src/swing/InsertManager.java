package swing;

import java.util.InputMismatchException;
import java.util.Scanner;



class InsertManager
{
    private static final Scanner sc = new Scanner(System.in);

    public void insert(int type)
    {
        int id = getValidIdFromUser();
        if (id == -1) return;

        switch (type) {
            case 1 -> insertStudent(id);
            case 2 -> insertProfessor(id);
            case 3 -> insertStaff(id);
            default -> UserManager.disable();
        }
    }

    private int getValidIdFromUser()
    {
        while (true)
        {
            try
            {
                System.out.println(">> 추가하고자 하는 id를 입력하세요!");
                System.out.print(">> ");
                int id = sc.nextInt();
                System.out.println();

                if (id <= 0)
                {
                    UserManager.disable();
                    return -1;
                }
                if (UserManager.users.containsKey(id)) 
                {
                    System.out.println("이미 존재하는 id입니다. 다른 id를 넣으세요!\n");
                } 
                else 
                {
                    return id;
                }
            } 
            catch (InputMismatchException e) 
            {
                sc.nextLine(); // 버퍼 클리어
                System.out.println("숫자를 입력해야 합니다.\n");
                UserManager.disable();
                return -1;
            }
        }
    }

    private String readString(String prompt) 
    {
        System.out.print(">> " + prompt + ": ");
        return sc.next();
    }

    private String readLine(String prompt) 
    {
        System.out.print(">> " + prompt + ": ");
        sc.nextLine(); // 버퍼 클리어
        return sc.nextLine();
    }

    private int readInt(String prompt) 
    {
        while (true) 
        {
            try 
            {
                System.out.print(">> " + prompt + ": ");
                return sc.nextInt();
            } 
            catch (InputMismatchException e) 
            {
                sc.nextLine();
                System.out.println("숫자를 다시 입력해주세요.");
            }
        }
    }

    private void insertStudent(int id) 
    {
        System.out.println(">> [ Student ] 레코드 추가를 시작합니다.\n");

        String name = readString("name");
        int age = readInt("age");
        String address = readLine("address");
        int grade = readInt("grade");
        int studentIdNo = readInt("studentIdNo");
        String major = readString("major");

        Student user = new Student(name, age, address, grade, studentIdNo, major);
        confirmAndInsert(id, user);
    }

    private void insertProfessor(int id) 
    {
        System.out.println(">> [ Professor ] 레코드 추가를 시작합니다.\n");

        String name = readString("name");
        int age = readInt("age");
        String address = readLine("address");
        int salary = readInt("salary");
        String position = readString("position");
        String major = readString("major");
        String course = readString("course");

        Professor user = new Professor(name, age, address, salary, position, null, major, course);
        confirmAndInsert(id, user);
    }

    private void insertStaff(int id) 
    {
        System.out.println(">> [ Staff ] 레코드 추가를 시작합니다.\n");

        String name = readString("name");
        int age = readInt("age");
        String address = readLine("address");
        int salary = readInt("salary");
        String position = readString("position");
        String department = readString("department");

        Staff user = new Staff(name, age, address, salary, position, null, department);
        confirmAndInsert(id, user);
    }

    private void confirmAndInsert(int id, Person user) 
    {
        UserManager.addUser(id, user);
        System.out.println();
        System.out.println(">> 레코드가 성공적으로 추가되었습니다.\n");
        UserManager.start();
    }
}
