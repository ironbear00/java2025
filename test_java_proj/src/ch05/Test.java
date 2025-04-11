package ch05;

public class Test
{
	public static void main(String [] args)
	{
//		classInheritance();
//		superTest();
		methodOverridingEx();
		//interfaceEx();
		//interfaceEx_two(3, 5);
	}
	
	
	public static void classInheritance()
	{
		Point p=new Point(1,2);
		//p.set(1, 2);
		p.showPoint();
		
		ColorPoint cp=new ColorPoint(3, 4);
		//cp.set(3, 4);
		cp.setColor("red");
		cp.showColorPoint();
	}
	
	public static void superTest()
	{
		ColorPoint cp=new ColorPoint(6, 7, "blue");
		cp.showColorPoint();
	}

	static void paint(Shape p)
	{
		p.draw();
	}
	
	public static void methodOverridingEx()
	{
		Line line=new Line();
		paint(line);
		
		paint(new Shape());
		paint(new Line());
		paint(new Rect());
		paint(new Circle());
	}
	
	public static void interfaceEx()
	{
		SamsungPhone phone = new SamsungPhone();
		phone.printLog();
		phone.sendCall();
		phone.receiveCall();
		phone.flash();
	}
	
	public static void interfaceEx_two(int a, int b)
	{
		a=3;
		b=5;
		SmartPhone sp=new SmartPhone();
		sp.printLog();
		sp.sendCall();
		System.out.printf("%d과 %d를 더하면 %d", a, b,sp.calculate(a, b));
		System.out.println();
		sp.schedule();
	}

	
	

















}
