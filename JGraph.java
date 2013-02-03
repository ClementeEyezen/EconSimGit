package EconSimGit;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;



public class JGraph extends JPanel 
{
	private Curve draw;
	private int points;
	public JGraph(Curve toDraw)
	{
		super();
		draw = toDraw;
		points = Math.min(draw.getList(true).size(), draw.getList(false).size());
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		System.out.println("super method called");
		//int w = this.getWidth();
		//int h = this.getHeight();
		Dimension d = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int w = (int) (.8*d.getWidth());
		int h = (int) (.8*d.getHeight());
		g.setColor(Color.BLACK);
		//draw axes
		g.drawLine(0,(int) (.9*h),(int) (w),(int) (.9*h));
		g.drawLine((int) (.1*w),0,(int) (.1*w),(int) (h));
		//draw Curve
		ArrayList<Double> xset = draw.getList(true);
		ArrayList<Double> yset = draw.getList(false);
		double xmax = draw.xmax;
		double ymax = draw.ymax;
		double pixPerX = (w*.8)/xmax;
		double pixPerY = (h*.8)/ymax;
		System.out.println("xmax, ymax "+xmax+" , "+ymax);
		System.out.println("pix per x,y "+pixPerX+" , "+pixPerY);
		//draw unit String
		g.drawString(draw.xUnit, (int) (.5*w), (int) (.9*h));
		g.drawString(draw.yUnit, (int) (.1*w), (int) (.5*h));
		//draw unit markers
		g.setColor(Color.BLACK);
		for (int i = 0; i <=Math.max(xmax, ymax); i++)
		{
			g.drawLine((int) (.05*w),(int) (.9*h-pixPerY*i),(int) (.15*w),(int) (.9*h-pixPerY*i));
			g.drawLine((int) (.1*w+pixPerX*i),(int) (.95*h),(int) (.1*w+pixPerX*i),(int) (.85*h));
		}
		g.setColor(Color.RED);
		System.out.println("color set Red");
		for (int i = 0; i<points-1; i++)
		{
			//real values
			double x1a = xset.get(i);
			double x2a = xset.get(i+1);
			double y1a = yset.get(i);
			double y2a = yset.get(i+1);
			//framed values (rotated plus scaled)s
			int x1 = (int) (x1a*pixPerX+.1*w);
			int x2 = (int) (x2a*pixPerX+.1*w);
			int y1 = (int) (h-y1a*pixPerY-.1*h);
			int y2 = (int) (h-y2a*pixPerY-.1*h);
			System.out.println("line drawn from "+x1a+","+y1a+" to "+x2a+","+y2a);
			System.out.println("line drawn from "+x1+","+y1+" to "+x2+","+y2);
			g.drawLine(x1, y1, x2, y2);
		}
	}
}
