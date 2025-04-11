package ch05_ex;

class ColorPoint extends Point
{
	private String color;
	
	public ColorPoint(int x, int y, String color)
	{
		super(x, y);
		this.color=color;
	}
	public ColorPoint(int x, int y) {this(x, y, "BLACK");}
	public ColorPoint() {this(0, 0, "BLACK");}
	
	public void setXY(int x, int y) {move(x, y);}
	public void setColor(String color) {this.color=color;}
	
	@Override
	public String toString()
	{
		return String.format("%s색의 (%d, %d)의 점입니다.", color, getX(), getY());
	}
}
