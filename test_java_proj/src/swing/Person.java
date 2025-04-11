package swing;

enum UserType
{
	STUDENT,
	PROFESSOR,
	STAFF;
}


class Person
{
	private String name;
	private int age;
	private String address;
	
	protected UserType userType; 
	
	Person(){name="";}
	Person(String name, int age)
	{
		this.name=name;
		this.age=age;
	}
	Person(String name, int age, String address)
	{
		this.name=name;
		this.age=age;
		this.address=address;
	}
	
	public String getName() {return name;}
	public void setName(String name) {this.name=name;}
	
	public int getAge() {return age;}
	public void setAge(int age) {this.age=age;}
	
	public String getAddress() {return address;}
	public void setAddress(String address) {this.address=address;}

	public UserType getUserType() {return userType;}
	
	public void info()
	{
		System.out.println();
		System.out.printf("이름: %s\n", name);
		System.out.printf("나이: %d\n", age);
		System.out.printf("주소: %s\n", address);
	}
}
