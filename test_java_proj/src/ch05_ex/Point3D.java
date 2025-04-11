package ch05_ex;

class Point3D extends Point
{
	private int z;
	
	public Point3D(int x, int y, int z)
	{
		super(x, y);
		this.z=z;
	}
	public void move(int x, int y, int z)
	{
		move(x, y);
		this.z=z;
	}
	public void moveUp()
	{
		this.z++;
	}
	public void moveDown()
	{
		this.z--;
	}
	
	@Override
	public String toString()
	{
		return String.format("(%d, %d, %d)의 점입니다.", getX(), getY(), z);
	}
}
