package ch05;

class SmartPhone extends Calc implements PhoneInterface
{
	public void sendCall()
	{
		System.out.println("따르를rrrrrrrrr릉");
	}
	public void receiveCall()
	{
		System.out.println("전화왔슈~");
	}
	public void schedule()
	{
		System.out.println("일정을 관리합니당");
	}
}
