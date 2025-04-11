package ch04_ex;

public class Dictionary
{
	private static String[] kor= {"사랑", "아기", "돈", "미래", "희망"};
	private static String[] eng= {"love", "baby", "money", "future", "hope"};
	
	public static String korToEng(String word)
	{
		for(int i=0; i<kor.length; i++)
		{
			if(word.equals(kor[i]))
			{
				return eng[i];
			}
		}
		//not exist
		return word="저의 사전에 없습니다.";
	}
}
