package swing;
class Professor extends Employee 
{
    private String major;
    private String course;

    Professor() 
    {
        this("", 0, "", 0, "", null, "", "");
    }
    
    // 🔹 address 추가
    Professor(String name, int age, String address, int salary, String position, Employee manager, String major, String course) 
    {
        super(name, age, address, salary, position, manager); // 🔹 address 반영
        this.major = major;
        this.course = course;
        this.userType=UserType.PROFESSOR;
    }

    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    @Override
    public void info() 
    {
        super.info();
        System.out.println("전공: " + major);
        System.out.println("강의: " + course);
        System.out.println();
    }
    
    @Override
    public String toString() 
    {
        return String.format("name: %s\nage: %d\naddress: %s\nsalary: %d\nposition: %s\nmanagerId: %d\nmajor: %s\ncourse: %s",
                             getName(), getAge(), getAddress(), getSalary(), getPosition(),
                             getManager() != null ? getManager().getName() : "",
                             getMajor(), getCourse());
    }

}
