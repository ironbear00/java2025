package swing;

class Student extends Person 
{
    private int studentIdNo;
    private int grade;
    private String major;

    Student() 
    {
        this("", 0, "", 0, 0, "");
    }

    Student(String name, int age, String address, int grade) 
    {
        this(name, age, address, grade, 0, "");
    }

    Student(String name, int age, String address, int grade, int studentIdNo) 
    {
        this(name, age, address, grade, studentIdNo, "");
    }

    Student(String name, int age, String address, int grade, int studentIdNo, String major) 
    {
        super(name, age, address); // 🔹 address 추가
        this.grade = grade;
        this.studentIdNo = studentIdNo;
        this.major = major;
        this.userType=UserType.STUDENT;
    }

    public int getGrade() { return grade; }
    public void setGrade(int grade) { this.grade = grade; }

    public int getStudentIdNo() { return studentIdNo; }
    public void setStudentIdNo(int studentIdNo) { this.studentIdNo = studentIdNo; }

    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }

    @Override
    public void info() 
    {
        super.info();
        System.out.println("학번: " + studentIdNo);
        System.out.println("학년: " + grade);
        System.out.println("전공: " + major);
        System.out.println();
    }
    
    @Override
    public String toString() 
    {
        return String.format("name: %s\nage: %d\naddress: %s\ngrade: %d\nstudentIdNo: %d\nmajor: %s",
                             getName(), getAge(), getAddress(), getGrade(), getStudentIdNo(), getMajor());
    }

}

