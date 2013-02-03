package EconSimGit;

import java.awt.*;

import javax.swing.*;



public class TestJGraph 
{
	public static void main(String[] args)
	{
		JFrame sally = new JFrame("titel bar Sally");
		Dimension d = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int w = (int) d.getWidth();
		int h = (int) d.getHeight();
		sally.setBounds((int) (.1*w),(int) (.1*h),(int) (.8*w),(int) (.8*h)); //the first two are the top left corner, then width and height
		sally.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //make sure memory is freed up on close
		sally.setBackground(Color.RED);
		Curve james = new Curve("units (#)","price ($)");
		james.addPoint(100.0, 1.0);
		james.addPoint(1.0, 100.0);
		for (int i = 0; i<100; i++)
		{
			//draw a random curve
			//james.addPoint(Math.random()*100, Math.random()*100);
			//draw a sin curve
			james.addPoint(100*Math.cos(Math.PI*.005*i), 100*Math.sin(Math.PI*.005*i));
			//draw an exponential decay curve
			//james.addPoint(i+2, 100*Math.pow(Math.E, -1*(i+2)));
			//draw a linear curve
			//james.addPoint(i, (100.0-i));
			
		}
		JGraph graphic = new JGraph(james); graphic.setBackground(Color.WHITE); graphic.setBounds(0, 0, (int) (100), (int) (100));
		sally.add(graphic);
		sally.setVisible(true); //makes it finally visible
	}
}
