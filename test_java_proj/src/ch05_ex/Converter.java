package ch05_ex;
import java.util.*;

abstract class Converter
{
	abstract protected double convert(double src);
	abstract protected String srcString();
	abstract protected String destString();
	
	protected double ratio;
	
	public void run()
	{
		Scanner sc=new Scanner(System.in);
		System.out.printf("%s을 %s로 바꿉니다.", srcString(), destString());
		System.out.println();
		System.out.printf("%s을 입력하세요>> ", srcString());
		double val=sc.nextDouble();
		double res=convert(val);
		System.out.printf("변환 결과: %.1f%s입니다.", res, destString());
		sc.close();
	}
}
