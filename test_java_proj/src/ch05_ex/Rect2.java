package ch05_ex;

public class Rect2 implements Shape2
{
	private int x;
	private int y;
	public Rect2(int x, int y)
	{
		this.x=x;
		this.y=y;
	}
	public void draw()
	{
		System.out.printf("%dx%d 크기의 사격형입니다.", x, y);
		System.out.println();
	}
	public double getArea()
	{
		return x*y;
	}
}
