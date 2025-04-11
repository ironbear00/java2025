package ch05_ex;

public class Dictionary extends PairMap
{
	private int index;
	
	public Dictionary(int length)
	{
		keyArray=new String[length];
		valueArray=new String[length];
		index=0;
	}
	//조건에서 null 체크를 먼저 해줘야지 nullexception이 발생하지 않음!
	public String get(String key)
	{
		for(int i=0; i<keyArray.length; i++)
		{
			if(keyArray[i]!=null && keyArray[i].equals(key)) return valueArray[i];
		}
		return "...누구세요?";
	}
	
	//key값이 중복이 없으면 넣고 있으면 value 갱신
	public void put(String key, String value)
	{
		for(int i=0; i<keyArray.length; i++)
		{
			if(keyArray[i] !=null && keyArray[i].equals(key))
			{
				valueArray[i]=value;
				return;
			}
		}
		//중복 없고 사전에 자리가 남으면
		if(length()<keyArray.length)
		{
			keyArray[index]=key;
			valueArray[index]=value;
			index++;
		}
		else
		{
			System.out.println("사전 꽉 참!");
		}
	}

	//key값은 삭제가 안됐기 때문에 빈공간 당기지 않음!
	public String delete(String key)
	{
		int del_index=0;
		for(int i=0; i<keyArray.length; i++)
		{
			if(keyArray[i] !=null && keyArray[i].equals(key))
			{
				valueArray[i]=null;
				del_index=i;
			}
		}
		return valueArray[del_index];
	}
	public int length()
	{
		return index;
	}
}
