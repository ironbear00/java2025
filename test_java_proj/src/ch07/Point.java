package ch07;

class Point
{
	private int x, y;
	public Point(int x, int y)
	{
		this.x=x;
		this.y=y;
	}
	
	public String toString()
	{
		return String.format("(%d, %d)", x, y);
	}
}
