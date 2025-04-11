package ch07;
import java.util.*;

public class Collections
{

	public static void main(String[] args)
	{
		//VectorEx();
		//PointVectorEx();
		//ArrayListEx();
		//IteratorEx();
		//HashMapDicEx();
		MyStack();
	}
	
	public static void VectorEx()
	{
		Vector<Integer> v=new Vector<Integer>();
		v.add(5);
		v.add(4);
		v.add(-1);
		
		v.add(2, 100);
		System.out.println(v.size());
		System.out.println(v.capacity());
		
		for(int i=0; i<v.size(); i++)
		{
			int n=v.get(i);
			System.out.println(n);
		}
		
		int sum=0;
		for(int i=0; i<v.size(); i++)
		{
			int n=v.elementAt(i);
			sum+=n;
		}
		System.out.println(sum);
	}

	public static void PointVectorEx()
	{
		Vector<Point> v= new Vector<Point>();
		
		v.add(new Point(2, 3));
		v.add(new Point(-5, 20));
		v.add(new Point(30, -8));
		v.remove(1);
		
		for(int i=0; i<v.size(); i++)
		{
			Point p=v.get(i);
			System.out.println(p);
		}
	}

	public static void ArrayListEx()
	{
		ArrayList<String> al=new ArrayList<String>();
		
		Scanner sc=new Scanner(System.in);
		for(int i=0; i<4; i++)
		{
			System.out.print("이름을 입력하세요.");
			String s=sc.next();
			al.add(s);
		}
		sc.close();
		
		for(int i=0; i<al.size(); i++)
		{
			String name=al.get(i);
			System.out.printf("%s ", name);
		}
		System.out.println();
		
		int longest=0;
		for(int i=0; i<al.size(); i++)
		{
			if(al.get(longest).length()<al.get(i).length())
			{
				longest=i;
			}
		}
		System.out.printf("가장 긴 이름은 %s", al.get(longest));
	}

	public static void IteratorEx()
	{
		Vector<Integer> v= new Vector<Integer>();
		v.add(5);
		v.add(4);
		v.add(-1);
		v.add(2, 100);
		
		Iterator<Integer> it=v.iterator();
		while(it.hasNext())
		{
			int n=it.next();
			System.out.println(n);
		}
		
		int sum=0;
		it=v.iterator();
		while(it.hasNext())
		{
			int n=it.next();
			sum+=n;
		}
		System.out.println(sum);
	}

	public static void HashMapDicEx()
	{
		HashMap<String, String> dic=new HashMap<String, String>();
		
		dic.put("baby", "아기");
		dic.put("love", "사랑");
		dic.put("apple", "사과");
		
		Set<String> keys=dic.keySet();
		Iterator<String> it=keys.iterator();
		while(it.hasNext())
		{
			String key=it.next();
			String value=dic.get(key);
			System.out.printf("(%s, %s)", key, value);
		}
		System.out.println();
		
		Scanner sc=new Scanner(System.in);
		for(int i=0; i<3; i++)
		{
			System.out.print("찾고 싶은 단어는?");
			String eng=sc.next();
			String kor=dic.get(eng);
			if(kor==null)
			{
				System.out.println(eng+"는 없는 단어입니다.");
			}
			else
			{
				System.out.println(kor);
			}
		}
		sc.close();
	}
	
	public static void MyStack()
	{
		GStack<String> stringStk=new GStack<String>();
		stringStk.push("seoul");
		stringStk.push("busan");
		stringStk.push("LA");
		
		for(int i=0; i<3; i++)
		{
			System.out.println(stringStk.pop());
		}
		
		GStack<Integer> intStk=new GStack<Integer>();
		intStk.push(1);
		intStk.push(3);
		intStk.push(5);
		
		for(int i=0; i<3; i++)
		{
			System.out.println(intStk.pop());
		}
	}














}
