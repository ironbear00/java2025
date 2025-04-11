package ch04;

public class Round
{

	int radius;
	
	public Round(int radius)
	{
		this.radius=radius;
	}
	public double getArea()
	{
		return 3.14*Math.pow(radius, 2);
	}
}
