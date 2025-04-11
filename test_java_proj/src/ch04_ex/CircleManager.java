package ch04_ex;
import java.util.*;

public class CircleManager
{
	void run(Scanner sc)
	{
		Circle[] c=new Circle[3];
		int[] circles=new int[c.length];
		
		for(int i=0; i<c.length; i++)
		{
			System.out.print("x, y, radius>>");
			double x=sc.nextDouble();
			double y=sc.nextDouble();
			int radius=sc.nextInt();
			c[i]=new Circle(x, y, radius);
			circles[i]=c[i].getRadius();
		}
		
		//show the biggest one
		int bigIndex=0;
		for(int i=1; i<c.length; i++)
		{
			if(c[i].getRadius()>c[bigIndex].getRadius())
			{
				bigIndex=i;
			}
		}
		c[bigIndex].showBig();
		
		
		//show all
//		for(int i=0; i<c.length; i++)
//		{
//			c[i].show();
//		}
	}
}
