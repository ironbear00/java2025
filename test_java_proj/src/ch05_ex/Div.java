package ch05_ex;

public class Div extends Calc
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
		if(b==0)
		{
			System.out.print("0으로는 나눌 수 없습니다..0_");
			return 0;
		}
		return (int)a/b;
	}
}
