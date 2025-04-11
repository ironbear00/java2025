package swing;

class Staff extends Employee 
{
    private String department;
    
    Staff() 
    {
        this("", 0, "", 0, "", null, "");
    }
    
    // 🔹 address 추가
    Staff(String name, int age, String address, int salary, String position, Employee manager, String department)
    {
        super(name, age, address, salary, position, manager); // 🔹 address 반영
        this.department = department;
        this.userType=UserType.STAFF;
    }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    @Override
    public void info() 
    {
        super.info();
        System.out.println("부서: " + department);
        System.out.println();
    }
    
    @Override
    public String toString() 
    {
        return String.format("name: %s\nage: %d\naddress: %s\nsalary: %d\nposition: %s\nmanagerId: %d\ndepartment: %s",
                             getName(), getAge(), getAddress(), getSalary(), getPosition(),
                             getManager() != null ? getManager().getName() : "",
                             getDepartment());
    }

}
