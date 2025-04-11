package swing;
import java.util.*;


import java.io.*;

class FileManager
{
	public void importFile(String fileName) 
	{
	    File file = new File(fileName);

	    if (!file.exists()) 
	    {
	        System.out.println(">> 파일이 존재하지 않습니다.\n");
	        return;
	    }

	    try (BufferedReader reader = new BufferedReader(new FileReader(file))) 
	    {
	        String line;
	        Person person = null;
	        String type = "";
	        Map<String, String> fields = new HashMap<>();

	        while ((line = reader.readLine()) != null) 
	        {
	            line = line.trim();

	            if (line.isEmpty()) continue;

	            if (line.matches("\\[.*\\]")) 
	            {
	                if (!fields.isEmpty() && person != null) 
	                {
	                    try 
	                    {
	                        addUser(fields, person);
	                    } 
	                    catch (Exception e) 
	                    {
	                        System.out.println(">> 레코드 저장 중 오류 발생: " + e.getMessage());
	                    }
	                    fields.clear();
	                    person = null;
	                }

	                type = line.substring(1, line.length() - 1).toLowerCase();
	                switch (type) 
	                {
	                    case "student": person = new Student(); break;
	                    case "professor": person = new Professor(); break;
	                    case "staff": person = new Staff(); break;
	                    default: person = null;
	                }
	            } 
	            else if (person != null && line.contains(":")) 
	            {
	                String[] parts = line.split(":", 2);
	                if (parts.length == 2) 
	                {
	                    String key = parts[0].trim().toLowerCase().replaceAll("\\s+", "");
	                    String value = parts[1].trim();
	                    fields.put(key, value);
	                }
	            }
	        }

	        // 마지막 레코드 저장 시도
	        if (!fields.isEmpty() && person != null) 
	        {
	            try 
	            {
	                addUser(fields, person);
	            } 
	            catch (Exception e) 
	            {
	                System.out.println(">> 마지막 레코드 저장 중 오류 발생: " + e.getMessage());
	            }
	        }

	        System.out.println(">> 사용자 정보가 성공적으로 불러와졌습니다.\n");

	    } 
	    catch (Exception e) 
	    {
	        System.out.println(">> 파일 읽기 중 오류 발생: " + e.getMessage());
	    }

	    UserManager.start();
	}

	private void addUser(Map<String, String> fields, Person person)
	{		
	    try 
	    {
	        if (person == null) return;
	        
	        if (!fields.containsKey("id") || !fields.containsKey("name") || !fields.containsKey("age")) return;

	        int id = Integer.parseInt(fields.get("id"));
	        person.setName(fields.get("name"));
	        person.setAge(Integer.parseInt(fields.get("age")));
	        person.setAddress(fields.getOrDefault("address", ""));

	        if (person instanceof Student) 
	        {
	            ((Student) person).setGrade(Integer.parseInt(fields.getOrDefault("grade", "0")));
	            ((Student) person).setStudentIdNo(Integer.parseInt(fields.getOrDefault("studentno", "0")));
	            ((Student) person).setMajor(fields.getOrDefault("major", ""));
	        } 
	        else if (person instanceof Professor) 
	        {
	            ((Professor) person).setSalary(Integer.parseInt(fields.getOrDefault("salary", "0")));
	            ((Professor) person).setPosition(fields.getOrDefault("position", ""));
	            ((Professor) person).setMajor(fields.getOrDefault("major", ""));
	            ((Professor) person).setCourse(fields.getOrDefault("course", ""));
	        } 
	        else if (person instanceof Staff) 
	        {
	            ((Staff) person).setSalary(Integer.parseInt(fields.getOrDefault("salary", "0")));
	            ((Staff) person).setPosition(fields.getOrDefault("position", ""));
	            ((Staff) person).setDepartment(fields.getOrDefault("department", ""));
	        }

	        if (UserManager.users == null)
			{
			    UserManager.users = new HashMap<>();
			}
			UserManager.users.put(id, person);
	    } 
	    catch (Exception e) 
	    {
	        System.out.println(">> 잘못된 레코드로 인해 저장 실패: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	
	
	public void exportFile()
	{
	    String baseName = "output";
	    String extension = ".txt";
	    int counter = 0;
	    File file;

	    // 파일명이 중복되지 않도록 새 파일명 찾기
	    while (true) 
	    {
	        String fileName = (counter == 0) ? baseName + extension : baseName + counter + extension;
	        file = new File(fileName);
	        if (!file.exists()) break;
	        counter++;
	    }

	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) 
	    {
	        if (UserManager.users.isEmpty()) 
	        {
	            writer.write("현재 등록된 사용자가 없습니다.\n");
	        } 
	        else 
	        {
	            for (Map.Entry<Integer, Person> entry : UserManager.users.entrySet()) {
	                int id = entry.getKey();
	                Person user = entry.getValue();

	                writer.write("[ID: " + id + "]\n");
	                writer.write(user.toString() + "\n\n"); // 반드시 toString 오버라이딩 되어 있어야 함
	            }
	        }
	        System.out.println(">> 사용자 정보가 파일로 저장되었습니다: " + file.getName() + "\n");
	    } 
	    catch (IOException e) 
	    {
	        System.out.println(">> 파일 저장 중 오류 발생: " + e.getMessage() + "\n");
	    }

	    UserManager.start();
	}

}
