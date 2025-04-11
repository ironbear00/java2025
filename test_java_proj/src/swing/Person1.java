package swing;

public abstract class Person1 
{
    private int id;
    private String name;
    private int age;
    private String address;

    public Person1(int id, String name, int age, String address) 
    {
        this.id = id; this.name = name; this.age = age; this.address = address;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getAddress() { return address; }

    public abstract String getInfo();

    @Override
    public String toString() {
        return String.format("id: %d\nname: %s\nage: %d\naddress: %s", id, name, age, address == null ? "" : address);
    }
}

class Student1 extends Person1 
{
    private int grade, studentNo;
    private String major;

    public Student1(int id, String name, int age, String address,
                   int grade, int studentNo, String major) 
    {
        super(id, name, age, address);
        this.grade = grade; this.studentNo = studentNo; this.major = major;
    }

    public int getGrade() { return grade; }
    public int getStudentNo() { return studentNo; }
    public String getMajor() { return major; }

    public String getInfo() 
    {
        return String.format("grade: %d\nstudentNo: %d\nmajor: %s", grade, studentNo, major);
    }

    @Override
    public String toString() {
        return "[Student]\n" + super.toString() + "\n" + getInfo();
    }
}

class Professor1 extends Person1 
{
    private int salary;
    private String position, major, course;

    public Professor1(int id, String name, int age, String address,
                     int salary, String position, String major, String course) 
    {
        super(id, name, age, address);
        this.salary = salary; this.position = position;
        this.major = major; this.course = course;
    }

    public int getSalary() { return salary; }
    public String getPosition() { return position; }
    public String getMajor() { return major; }
    public String getCourse() { return course; }

    public String getInfo() 
    {
        return String.format("salary: %d\nposition: %s\nsupervisor: %s\ncourse: %s",
                             salary, position, major, course);
    }

    @Override
    public String toString() {
        return "[Professor]\n" + super.toString() + "\n" + getInfo();
    }
}

class Staff1 extends Person1 
{
    private int salary;
    private String position, department;

    public Staff1(int id, String name, int age, String address,
                 int salary, String position, String department) 
    {
        super(id, name, age, address);
        this.salary = salary; this.position = position;
        this.department = department;
    }

    public int getSalary() { return salary; }
    public String getPosition() { return position; }
    public String getDepartment() { return department; }

    public String getInfo() 
    {
        return String.format("salary: %d\nposition: %s\nsupervisor: \ndepartment: %s",
                             salary, position, department);
    }

    @Override
    public String toString() {
        return "[Staff]\n" + super.toString() + "\n" + getInfo();
    }
}
