package ch05_ex;

public class Sub extends Calc
{
	@Override
	public void setValue(int x, int y)
	{
		this.a=x;
		this.b=y;
	}
	@Override
	public int Calculate()
	{
		return a-b;
	}
}
