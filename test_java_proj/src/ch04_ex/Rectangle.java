package ch04_ex;

public class Rectangle
{
	private int x;
	private int y;
	private int width;
	private int height;
	
	public Rectangle()
	{
		x=0;
		y=0;
		width=0;
		height=0;
	}
	
	public Rectangle(int x, int y, int w, int h)
	{
		this.x=x;
		this.y=y;
		width=w;
		height=h;
	}
	
	public int square()
	{
		return width*height;
	}
	
	public void show()
	{
		System.out.printf("(%d, %d)에서 크기가 %dx%d인 사각형", x, y, width, height);
		System.out.println();
	}
	
	public boolean contains(Rectangle r)
	{
		if (r.x > x && r.x + r.width < x + width && r.y > y && r.y + r.height < y + height) return true;
		return false;
	}
}
