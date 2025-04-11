package ch05;

public class Point
{
	private int x;
	private int y;
	
	public void set(int x, int y)
	{
		this.x=x;
		this.y=y;
	}
	
	public Point(int x, int y)
	{
		this.x=x;
		this.y=y;
	}
	
	public void showPoint()
	{
		System.out.printf("(%d, %d)", x, y);
		System.out.println();
	}
}

class ColorPoint extends Point
{
	private String color;
	
	public ColorPoint(int x, int y)
	{
		super(x, y);
	}
	
	public ColorPoint(int x, int y, String color)
	{
		super(x,y);
		this.color=color;
	}
	
	public void setColor(String color)
	{
		this.color=color;
	}
	
	public void showColorPoint()
	{
		System.out.print(color);
		showPoint();
	}
}