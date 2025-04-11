package ch05_ex;
import java.util.*;

public class GraphicEditor
{
	private Shape first;
	public GraphicEditor() {first=null;}
	public void start(Scanner sc)
	{
		int input=0;
		while(true)
		{
			System.out.print("insert(1) delete(2) show all(3) exit(4)>>");
			try
			{
				input=sc.nextInt();
				break;
			}
			catch(Exception e)
			{
				System.out.print("알맞은 수를 입력하숑!");
				sc.nextLine();
			}
		}
		
		switch(input)
		{
			case 1:
				put(sc);
				break;
			case 2:
				delete(sc);
				break;
			case 3:
				show();
				start(sc);
				break;
			case 4:
				exit();
				break;
			default:
				System.out.print("알맞은 수를 입력하숑!");
		}
	}
	//linkedlist의 삽입
	private void put(Scanner sc)
	{
		int type=0;
		while(true)
		{
			System.out.print("Line(1) Rect(2) Circle(3)>>");
			try
			{
				type=sc.nextInt();
				break;
			}
			catch(Exception e)
			{
				System.out.print("알맞은 수를 입력하숑!");
				sc.nextLine();
			}
		}
		
		switch(type)
		{
			case 1:
				Shape line=new Line();
				addShape(line);
				start(sc);
				break;
			case 2:
				Shape rect=new Rect();
				addShape(rect);
				start(sc);
				break;
			case 3:
				Shape circle=new Circle();
				addShape(circle);
				start(sc);
				break;
			default:
				System.out.print("알맞은 수를 입력하숑!");
		}
	}
	private void addShape(Shape shape)
	{
		if(first==null) first=shape;
		else
		{
			Shape temp=first;
			while(temp.getNext()!=null)
			{
				temp=temp.getNext();
			}
			temp.setNext(shape);
		}
	}
	//linkedlist의 삭제
	private void delete(Scanner sc)
	{
		int index=0;
		System.out.print("삭제할 도형의 위치>>");
		try
		{
			index=sc.nextInt();
		}
		catch(Exception e)
		{
			System.out.print("삭제할 수 엄슴당..");
			sc.nextLine();
			start(sc);
		}
		deleteShape(index, sc);
	}
	private void deleteShape(int index, Scanner sc)
	{
		//첫 값 삭제
		if(first!=null && index==1)
		{
			first=first.getNext();
			start(sc);
			return;
		}
		
		//그 외
		Shape temp=first;
		for(int i=0; i<index-1; i++)
		{
			if(temp==null || temp.getNext()==null)
			{
				System.out.println("삭제할 도형이 없습니다.");
				start(sc);
				return;
			}
			temp=temp.getNext();
		}
		Shape del_shape=temp.getNext();
		if(del_shape!=null)
		{
			temp.setNext(del_shape.getNext());
			start(sc);
		}
		else
		{
			System.out.println("삭제할 도형이 없습니다.");
			start(sc);
		}
	}
	//출력
	private void show()
	{
		Shape temp=first;
		while(temp!=null)
		{
			temp.draw();
			temp=temp.getNext();
		}
	}
	private void exit()
	{
		System.out.print("G-v1.0을 종료합니당...");
	}
}
