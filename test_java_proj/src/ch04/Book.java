package ch04;

public class Book
{
	String title;
	String author;
	
	void show() {System.out.println(title+" "+author);}
	
	public Book()
	{
		this("", "");
		System.out.println("생성자 호출");
	}
	
	public Book(String t)
	{
		title=t;
		author="unknown";
	}
	
	public Book(String t, String a)
	{
		this.title=t;
		this.author=a;
	}
}
