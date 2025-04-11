package ch05_ex;

public class Oval implements Shape2
{
	private int x;
	private int y;
	public Oval(int x, int y)
	{
		this.x=x;
		this.y=y;
	}
	public void draw()
	{
		System.out.printf("%dx%d에 내접하는 타원입니다.", x, y);
		System.out.println();
	}
	public double getArea()
	{
		return x*y*PI/4;
	}
}
