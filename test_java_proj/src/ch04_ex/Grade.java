package ch04_ex;

public class Grade
{
	int math;
	int science;
	int english;
	
	public Grade()
	{
		math=0;
		science=0;
		english=0;
	}
	
	public Grade(int m, int s, int e)
	{
		math=m;
		science=s;
		english=e;
	}
	
	public int average()
	{
		return (math+science+english)/3;
	}
}
