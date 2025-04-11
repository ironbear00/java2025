package ch04_ex;

public class TV
{
	String name;
	int year;
	int size;
	
	public TV()
	{
		name="";
		year=1;
		size=10;
	}
	
	public TV(String n, int y, int s)
	{
		name=n;
		year=y;
		size=s;
	}
	
	public void show()
	{
		System.out.printf("%s에서 만든 %d년형 %d인치 TV", name, year, size);
	}
}
