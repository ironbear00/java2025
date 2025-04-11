package ch04_ex;
//import java.util.*;

public class Seat
{
	private String name;
	
	public void setName(String name) {this.name=name;}
	public String getName() {return name;}
	
	public void show()
	{
		if(name==null) System.out.print("--- ");
		else System.out.printf("%s ",name);
	}
	
}
