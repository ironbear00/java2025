package ch05_ex;

public class Circle2 implements Shape2
{
	private int r;
	public Circle2(int r)
	{
		this.r=r;
	}
	public void draw()
	{
		System.out.printf("반지름이 %d인 원입니다.", r);
		System.out.println();
	}
	public double getArea()
	{
		return r*PI;
	}
}


