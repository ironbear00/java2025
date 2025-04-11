package ch04_ex;

public class Circle
{
	private double x;
	private double y;
	private int radius;
	
	public Circle(double x, double y, int r)
	{
		this.x=x;
		this.y=y;
		radius=r;
	}
	
	public int getRadius()
	{
		return radius;
	}
	
	public void show()
	{
		System.out.printf("(%.1f,%.1f)%d", x, y, radius);
		System.out.println();
	}
	
	public void showBig()
	{
		System.out.printf("가장 면적이 큰 원은 (%.1f, %.1f)%d", x, y, radius);
	}
}
