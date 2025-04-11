package ch04;
import java.util.Scanner;

public class class_test
{

	public static void main(String[] args)
	{
		Circle circle=new Circle();
		Rectangle rectangle=new Rectangle();
		
		Scanner sc=new Scanner(System.in);
		
		//Pizza(circle);
		//Donut(circle);
		//RectApp(sc, rectangle);
		//CircleTwo();
		//Books();
		//RoundArray();
		//BookArray(sc);
		CalcEx();
		
		sc.close();
	}
	public static void CalcEx()
	{
		System.out.println(Calc.abs(-5));
		System.out.println(Calc.max(10, 8));
		System.out.println(Calc.min(-3, -8));
	}
	public static void BookArray(Scanner sc)
	{
		Book[] book_arr=new Book[2];
		//input
		for(int i=0; i<book_arr.length; i++)
		{
			System.out.print("제목>>");
			String title=sc.nextLine();
			System.out.print("저자>>");
			String author=sc.nextLine();
			book_arr[i]=new Book(title, author);
		}
		//output
		for(int i=0; i<book_arr.length; i++)
		{
			System.out.print("("+book_arr[i].title+","+book_arr[i].author+")");
		}
	}
	public static void RoundArray()
	{
		Round[] r=new Round[5];
		
		for(int i=0; i<r.length; i++)
		{
			r[i]=new Round(i);
			System.out.print((int)r[i].getArea()+" ");
		}
	}
	public static void Books()
	{
		Book littlePrince=new Book("Little Prince", "Saint-Exu-pery");
		Book loveStory=new Book("춘향전");
		Book emptyBook=new Book();
		
		loveStory.show();
		littlePrince.show();
		emptyBook.show();
	}
	public static void CircleTwo()
	{
		Circle pizza=new Circle(10, "피잇짜");
		double area=pizza.getArea();
		System.out.println(pizza.name+"의 면적은 "+area);
		
		Circle donut=new Circle();
		donut.name="도우낫";
		area=donut.getArea();
		System.out.println(donut.name+"의 면적은 "+area);
	}
	public static void Pizza(Circle pizza)
	{
		pizza.radius=10;
		pizza.name="핏짜";
		double area=pizza.getArea();
		System.out.println(pizza.name+"의 면적 "+area);
	}
	public static void Donut(Circle donut)
	{
		donut.radius=2;
		donut.name="도나쓰";
		double area=donut.getArea();
		System.out.println(donut.name+"의 면적 "+area);
	}
	public static void RectApp(Scanner sc, Rectangle rect)
	{
		System.out.print(">> ");
		rect.width=sc.nextInt();
		rect.height=sc.nextInt();
		System.out.printf("사각형의 면적은 %d", rect.getArea());
	}



}
