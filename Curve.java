package src.EconSimGit;

import java.util.ArrayList;

public class Curve 
{
	ArrayList<Double> xpoints = new ArrayList<Double>();
	ArrayList<Double> ypoints = new ArrayList<Double>();
	public String xUnit = "";
	public String yUnit = "";
	public double ymax;
	public double xmax;
	public Curve(String xU, String yU)
	{
		xUnit = xU;
		yUnit = yU;
	}
	public double maxX()
	{
		return xpoints.get(xpoints.size()-1);
	}
	public double getYValue(double xCoord)
	{
		if (xCoord>=0)
		{
			//returns the value of the yCoordinate for the given x
			if (xpoints.get(findLow(xCoord)) != xCoord)
			{		
				int low = findLow(xCoord);
				int high = low+1;
				double xlow = xpoints.get(low);
				double ylow = ypoints.get(low);
				double xhigh = xpoints.get(high);
				double yhigh = ypoints.get(high);
				double slope = (yhigh-ylow)/(xhigh/xlow);
				double distance = xCoord-xlow;
				double newVal = slope*distance+ypoints.get(low);
				xpoints.add(low, xCoord);
				ypoints.add(low, newVal);
				return newVal;
			}
			else
			{
				return xpoints.get(findLow(xCoord));
			}
		}
		else
		{
			return -1;
		}
	}
	public void addPoint(double xCoord, double yCoord) //find the value above the input
	{
		if (xCoord>=0)
		{
			int low = findLow(xCoord);
			if (low != -1)
			{
				xpoints.add(low, xCoord);
				ypoints.add(low, yCoord);
				if (yCoord>ymax)
				{
					ymax = yCoord;
				}
				if (xCoord>xmax)
				{
					xmax = xCoord;
				}
			}
			else
			{

			}
		}
	}
	public int findLow(double input) //find the value below the input
	{
		int i = 0;
		while(i<xpoints.size() && xpoints.get(i)<input)
		{
			i++;
		}
		return i;
	}
	public int findHigh(double input)
	{
		int i = xpoints.size();
		while(i>=0 && xpoints.get(i)>input)
		{
			if (i>=0)
			{
				i--;
			}
			else
			{
				return 0;
			}
		}
		return i+1;
	}
	public ArrayList<Double> getList(boolean XorY)
	{
		// x = true
		// y = false
		if (XorY) return xpoints;
		else return ypoints;
	}
	public double findIntersect(boolean MaxOrMin, double startPrice, double endPrice, Curve compared)
	{
		double price = startPrice;
		double delta = -.01;
		if (!MaxOrMin)
		{
			delta = .01;
			while (price < endPrice)
			{
				double difference = Math.abs(this.getYValue(price) - compared.getYValue(price));
				if (difference<.05)
				{
					return price;
				}
				else
				{
					price = price + delta;
				}
			}
			return -1;
		}
		else
		{
			while (price > endPrice)
			{
				double difference = Math.abs(this.getYValue(price) - compared.getYValue(price));
				if (difference<.05)
				{
					return price;
				}
				else
				{
					price = price + delta;
				}
			}
			return -1;
		}
	}
}
