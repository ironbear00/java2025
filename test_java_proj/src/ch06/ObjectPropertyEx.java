package ch06;
import java.util.*;

public class ObjectPropertyEx
{

	public static void main(String[] args)
	{
		//ObjectProperty();
		//ToString();
		//EqualsEx();
		//RectEx();
		//WrapperEx();
		//StringEx();
		//Tokenizer();
		MathEx();
	}
	
	public static void ObjectProperty()
	{
		Point p=new Point(2,3);
		System.out.println(p.getClass().getName());
		System.out.println(p.hashCode());
		System.out.println(p.toString());
	}
	
	public static void ToString()
	{
		Point a=new Point(2,3);
		System.out.println(a.toString());
		System.out.println(a);
	}
	
	public static void EqualsEx()
	{
		Point a=new Point(2,3);
		Point b=new Point(2,3);
		Point c=new Point(3, 4);
		
		if(a==b) System.out.println("a==b");
		if(a.equals(b)) System.out.println("a is equals to b");
		if(a.equals(c)) System.out.println("a is equals to c");
	}

	public static void RectEx()
	{
		Rect a=new Rect(2,3);
		Rect b=new Rect(3,2);
		Rect c=new Rect(4,4);
		
		if(a.equals(b))System.out.println("a is equals to b");
		if(a.equals(c))System.out.println("a is equals to c");
		if(b.equals(c))System.out.println("b is equals to c");
	}

	public static void WrapperEx()
	{
		System.out.println(Character.toLowerCase('A'));
		char c1='4';
		char c2='F';
		if(Character.isDigit(c1)) System.out.println(c1+"숫자");
		if(Character.isAlphabetic(c1)) System.out.println(c2+"문자");
	
		System.out.println(Integer.parseInt("28"));
		System.out.println(Integer.toString(28));
		System.out.println(Integer.toBinaryString(28));
		System.out.println(Integer.bitCount(28));
		Integer i=Integer.valueOf(28);
		System.out.println(i.doubleValue());
	
		Double d=Double.valueOf(3.14);
		System.out.println(d.toString());
		System.out.println(Double.parseDouble("3.14"));
		
		boolean b=(4>3);
		System.out.println(Boolean.toString(b));
		System.out.println(Boolean.parseBoolean("false"));
	}

	public static void StringEx()
	{
		String a=new String(" C#");
		String b=new String(", C++ ");
		
		System.out.println(a+"의 길이는 "+a.length());
		System.out.println(a.contains("#"));
		
		a=a.concat(b);
		System.out.println(a);
		
		a=a.trim();
		System.out.println(a);
		
		a=a.replace("C#", "Java");
		System.out.println(a);
		
		String[] s=a.split(",");
		for(int i=0; i<s.length; i++)
		{
			System.out.println("분리된 문자열"+i+":"+s[i]);
		}
		
		a=a.substring(5);
		System.out.println(a);
		
		char c=a.charAt(2);
		System.out.println(c);
	}

	public static void Tokenizer()
	{
		String query="name=kitae&addr=seoul&age=21";
		StringTokenizer st=new StringTokenizer(query, "&");
		
		int n=st.countTokens();
		System.out.printf("토큰개수 %d", n);
		System.out.println();
		
		while(st.hasMoreTokens())
		{
			String token=st.nextToken();
			System.out.println(token);
		}
	}

	public static void MathEx()
	{
		System.out.println(Math.abs(-3.14));
		System.out.println(Math.sqrt(9.0));
		System.out.println(Math.exp(2));
		System.out.println(Math.round(3.14));
		
		System.out.print("이번주 행운의 번호는..!?");
		for(int i=0; i<5; i++)
		{
			System.out.print((int)(Math.random()*45+1)+" ");
		}
		
	}





}
