package ch04_ex;

public class Song
{
	String title;
	String artist;
	int year;
	String country;
	
	public Song()
	{
		title="unknown";
		artist="unknown";
		year=9999;
		country="unknown";
	}
	
	public Song(String t, String a, int y, String c)
	{
		title=t;
		artist=a;
		year=y;
		country=c;
	}
	
	public void show()
	{
		System.out.printf("%d년 %s국적의 %s가 부른 %s", year, country, artist, title);
	}
}
