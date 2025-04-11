package ch05_ex;

class IPTV extends ColorTV
{
	private String ip;
	
	public IPTV(String ip, int size, int colors)
	{
		super(size, colors);
		this.ip=ip;
	}
	
	protected void printProperty()
	{
		System.out.printf("나의 IPTV는 %s 주소의 %d인치 %d컬러", 
				ip ,getSize(), getColors());
	}
}
