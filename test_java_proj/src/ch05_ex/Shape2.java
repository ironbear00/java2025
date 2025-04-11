package ch05_ex;

interface Shape2
{
	final double PI=3.14;
	void draw();
	double getArea();
	default public void redraw()
	{
		System.out.print("--- 다시 내가 그린 기린그림은 ");
		draw();
	}
}
