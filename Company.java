package EconSimGit;

public class Company 
{
	Curve demandCurve;
	Curve supplyCurve;
	String name;
	double cash;
	int factory;
	public Company()
	{
		this("Basic Name", 10000.00, 0);
	}
	public Company(String nam)
	{
		this(nam, 10000.0, 0);
	}
	public Company(String nam, double cas)
	{
		this(nam, cas, 0);
	}
	public Company(String nam, double cas, int factor)
	{
		demandCurve = new Curve ("Units", "Price");
		supplyCurve = new Curve ("Units", "Price");
		name = nam;
		cash = cas;
		factory = factor;
	}
}
