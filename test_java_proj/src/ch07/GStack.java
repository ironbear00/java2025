package ch07;

class GStack<T>
{
	int tos;
	Object[] stk;
	public GStack()
	{
		tos=0;
		stk=new Object[10];
	}
	
	public void push(T item)
	{
		if(tos==10) return;
		
		stk[tos]=item;
		tos++;
	}
	
	public T pop()
	{
		if(tos==0) return null;
		
		tos--;
		return (T)stk[tos];
	}
}
