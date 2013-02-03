package EconSimGit;

import java.util.ArrayList;

public class Market 
{
	//graphs passed to this should have price on the x-axis and units in play on the y-axis
	ArrayList<Curve> supplyCurves = new ArrayList<Curve>();
	ArrayList<Curve> demandCurves = new ArrayList<Curve>();
	String name = "";
	public Market(String str)
	{
		name = str;
	}
	public void addCurve(boolean SupplyOrDemand, Curve toAdd)
	{
		if (SupplyOrDemand)
		{
			supplyCurves.add(toAdd);
		}
		else
		{
			demandCurves.add(toAdd);
		}
	}
	public Curve[] returnMaxPriceCurve(double maxPrice)
	{
		double maxim = 0;
		Curve def = new Curve("non", "plus");
		Curve[] match = new Curve[2];
		match[0] = def;
		match[1] = def;
		for (Curve co:supplyCurves)
		{
			for (Curve ce:demandCurves)
			{
				double tint = co.findIntersect(true, maxim, maxPrice, ce);
				if (tint>maxim)
				{
					maxim = tint;
					match[0] = co;
					match[1] = ce;
				}
			}
		}
		return match;
	}
	public Curve[] returnMinPriceCurve(double minPrice)
	{
		double minim = 0;
		Curve def = new Curve("non", "plus");
		Curve[] match = new Curve[2];
		match[0] = def;
		match[1] = def;
		for (Curve co:supplyCurves)
		{
			for (Curve ce:demandCurves)
			{
				double tint = co.findIntersect(false, minim, minPrice, ce);
				if (tint<minim)
				{
					minim = tint;
					match[0] = co;
					match[1] = ce;
				}
			}
		}
		return match;
	}
}
