package ch04_ex;

public class Phone
{
	private String name;
	private String tel;
	
	public void setName(String name){this.name=name;}
	public String getName() {return name;}
	public void setTel(String tel) {this.tel=tel;}
	public String getTel() {return tel;}
	
	public void show()
	{
		if(name==null) System.out.println(name+"이 없습니다.");
		else System.out.println(name+"의 번호는 "+tel+" 입니다.");
	}
}
