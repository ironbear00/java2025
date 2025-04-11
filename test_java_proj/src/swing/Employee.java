package swing;

class Employee extends Person 
{
    private int salary;
    private String position;
    private Employee manager;

    // 🔹 address 추가
    Employee() 
    {
        this("", 0, "", 0, "", null);
    }

    Employee(String name, int age, String address, int salary) 
    {
        this(name, age, address, salary, "", null);
    }

    Employee(String name, int age, String address, int salary, String position) 
    {
        this(name, age, address, salary, position, null);
    }

    Employee(String name, int age, String address, int salary, String position, Employee manager) 
    {
        super(name, age, address); // 🔹 address 반영
        this.salary = salary;
        this.position = position;
        this.manager = manager;
    }

    public int getSalary() { return salary; }
    public void setSalary(int salary) { this.salary = salary; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public Employee getManager() { return manager; }
    public void setManager(Employee manager) { this.manager = manager; }

    @Override
    public void info() 
    {
        super.info();
        System.out.println("월급: " + salary);
        System.out.println("소속: " + position);
        System.out.println("상사: " + (manager != null ? manager.getName() : "없음")); // 🔹 null 체크 추가
    }
}
