package ch05_ex;

class PositivePoint extends Point
{
	public PositivePoint(int x, int y)
	{
		super(x, y);
		
		//조건은 super 뒤에 달 수 있음!
		if(x<0 || y<0)
		{
			super.move(0, 0);
		}
	}
	public PositivePoint() {this(0, 0);}
	
	@Override
	protected void move(int x, int y)
	{
		if(x>0 && y>0)
		{
			super.move(x,y);
		}
	}
	
	@Override
	public String toString()
	{
		return String.format("(%d, %d)의 점입니다.", getX(), getY());
	}
}
