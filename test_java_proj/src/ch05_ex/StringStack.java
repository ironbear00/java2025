package ch05_ex;

public class StringStack implements Stack
{
	private String[] stack;
	private int top;
	private int capacity;
	
	//create new stacks
	public StringStack(int capacity)
	{
		this.capacity=capacity;
		stack =new String[this.capacity];
		top=-1;
	}
	
	//return stored data's count
	public int length()
	{
		return top+1;
	}

	//return left capacity
	public int capacity()
	{
		return capacity-length();
	}
	
	//return last data
	public String pop()
	{
		if(top==-1)
		{
			return null;
		}
		String value=stack[top];
		stack[top]=null;
		top--;
		return value;
	}
	
	//store
	public boolean push(String val)
	{
		if(capacity()==0)
		{
			return false;
		}
		stack[++top]=val;
		return true;
	}
	
	public boolean isEmpty()
	{
		return length()==0;
	}
}
