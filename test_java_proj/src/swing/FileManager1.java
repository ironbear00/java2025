package swing;
import java.util.*;
import java.io.*;

public class FileManager1 
{
    public static List<Person1> importFromFile(File file) 
    {
        List<Person1> people = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) 
        {
            String line;
            Map<String, String> fields = new HashMap<>();
            String type = null;

            while ((line = reader.readLine()) != null) 
            {
                line = line.trim();
                if (line.isEmpty()) continue;

                if (line.startsWith("[") && line.endsWith("]")) 
                {
                    if (!fields.isEmpty()) 
                    {
                        people.add(createPerson(type, fields));
                        fields.clear();
                    }
                    type = line.substring(1, line.length() - 1).toLowerCase();
                } 
                else if (line.contains(":")) 
                {
                    String[] parts = line.split(":", 2);
                    if (parts.length == 2)
                        fields.put(parts[0].trim().toLowerCase(), parts[1].trim());
                }
            }

            if (!fields.isEmpty()) 
            {
                people.add(createPerson(type, fields));
            }

        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }

        return people;
    }

    private static Person1 createPerson(String type, Map<String, String> f) 
    {
        try 
        {
            int id = Integer.parseInt(f.get("id"));
            String name = f.get("name");
            int age = Integer.parseInt(f.get("age"));
            String address = f.getOrDefault("address", "");

            switch (type) 
            {
                case "student":
                    return new Student1(id, name, age, address,
                            Integer.parseInt(f.getOrDefault("grade", "0")),
                            Integer.parseInt(f.getOrDefault("studentno", "0")),
                            f.getOrDefault("major", ""));
                case "professor":
                    return new Professor1(id, name, age, address,
                            Integer.parseInt(f.getOrDefault("salary", "0")),
                            f.getOrDefault("position", ""),
                            f.getOrDefault("major", ""),
                            f.getOrDefault("course", ""));
                case "staff":
                    return new Staff1(id, name, age, address,
                            Integer.parseInt(f.getOrDefault("salary", "0")),
                            f.getOrDefault("position", ""),
                            f.getOrDefault("department", ""));
            }
        } 
        catch (Exception e) 
        {
            System.out.println(">> 레코드 파싱 오류: " + e.getMessage());
        }
        return null;
    }
}
