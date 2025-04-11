package ch05_ex;

class ColorTV extends TV
{
	private int colors;
	
	public ColorTV(int size, int colors)
	{
		super(size);
		this.colors=colors;
	}
	protected int getColors() {return colors;}
	
	protected void printProperty()
	{
		System.out.printf("%d인치 %d컬러", getSize(), colors);
	}
}
