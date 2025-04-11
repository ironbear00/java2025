package ch05;

interface PhoneInterface
{
	final int TIMEOUT=10000;
	void sendCall();
	void receiveCall();
	default void printLog()
	{
		System.out.println("**Phone**");
	}
}

class Calc
{
	public int calculate(int x, int y)
	{
		return x+y;
	}
}
