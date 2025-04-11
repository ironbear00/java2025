package ch05_ex;

public class KmToMile extends Converter
{
	public KmToMile(double ratio)
	{
		this.ratio=ratio;
	}
	
	@Override
	public double convert(double src)
	{
		return src/ratio;
	}
	
	@Override
	public String srcString()
	{
		return "Km";
	}
	
	@Override
	public String destString()
	{
		return "mile";
	}
}
