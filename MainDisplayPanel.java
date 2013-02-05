package src.EconSimGit;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MainDisplayPanel extends JFrame implements ActionListener, WindowListener, KeyListener
{
	public MainDisplayPanel()
	{
		super("Buck Baskin's Econ Sim");
		//build and add a menubar
		JMenuBar menubar = new JMenuBar();
		//begin file menu
		JMenu menu = new JMenu("File");
		JMenuItem menuitem = new JMenuItem("New");
		menuitem.addActionListener(this);
		menuitem.setActionCommand("New");
		menu.add(menuitem);
		menuitem = new JMenuItem("Open");
		menuitem.addActionListener(this);
		menuitem.setActionCommand("Open");
		menu.add(menuitem);
		menuitem = new JMenuItem("Save");
		menuitem.addActionListener(this);
		menuitem.setActionCommand("Save");
		menu.add(menuitem);
		menuitem = new JMenuItem("Close");
		menuitem.addActionListener(this);
		menuitem.setActionCommand("Close");
		menu.add(menuitem);
		menubar.add(menu);
		//end add file menu
		//begin edit menu
		menu = new JMenu("Edit");
		menuitem = new JMenuItem("Curves");
		menuitem.addActionListener(this);
		menuitem.setActionCommand("edit Curves");
		menu.add(menuitem);
		menuitem = new JMenuItem("Buy Curve");
		menuitem.addActionListener(this);
		menuitem.setActionCommand("edit Buy Curve");
		menu.add(menuitem);
		menuitem = new JMenuItem("Sell Curve");
		menuitem.addActionListener(this);
		menuitem.setActionCommand("edit Sell Curve");
		menu.add(menuitem);
		menuitem = new JMenuItem("R&D Curve");
		menuitem.addActionListener(this);
		menuitem.setActionCommand("edit R&D Curve");
		menu.add(menuitem);
		menuitem = new JMenuItem("Marketing Curve");
		menuitem.addActionListener(this);
		menuitem.setActionCommand("edit Marketing Curve");
		menu.add(menuitem);
		menubar.add(menu);
		//end add edit menu
		//begin view menu
		menu = new JMenu("View");
		menuitem = new JMenuItem("Curves");
		menuitem.addActionListener(this);
		menuitem.setActionCommand("view Curves");
		menu.add(menuitem);
		menuitem = new JMenuItem("Buy Curve");
		menuitem.addActionListener(this);
		menuitem.setActionCommand("view Buy Curve");
		menu.add(menuitem);
		menuitem = new JMenuItem("Sell Curve");
		menuitem.addActionListener(this);
		menuitem.setActionCommand("view Sell Curve");
		menu.add(menuitem);
		menuitem = new JMenuItem("R&D Curve");
		menuitem.addActionListener(this);
		menuitem.setActionCommand("view R&D Curve");
		menu.add(menuitem);
		menuitem = new JMenuItem("Marketing Curve");
		menuitem.addActionListener(this);
		menuitem.setActionCommand("view Marketing Curve");
		menu.add(menuitem);
		menuitem = new JMenuItem("Company Stats");
		menuitem.addActionListener(this);
		menuitem.setActionCommand("view Company Stats");
		menu.add(menuitem);
		menubar.add(menu);
		//end add view menu
		menuitem.addActionListener(this);
		this.setJMenuBar(menubar);
		//end add menubar
		//begin set layout
		JPanel mainLayout = new JPanel(new BorderLayout());
		int w = this.getWidth();
		int h = this.getHeight();
		JPanel north = new JPanel(); north.setBackground(Color.CYAN); north.setBounds((int) (0), (int) (0), (int) (w), (int) (.2*h));
		JPanel south = new JPanel(); south.setBackground(Color.BLUE); south.setBounds((int) (0), (int) (0), (int) (w), (int) (.2*h));
		JPanel east = new JPanel(); east.setBackground(Color.RED); east.setBounds((int) (0), (int) (0), (int) (w), (int) (.2*h));
		JPanel west = new JPanel(); west.setBackground(Color.ORANGE); west.setBounds((int) (0), (int) (0), (int) (w), (int) (.2*h)); west.setLayout(new GridLayout(10,0));
		JPanel center = new JPanel(); center.setBackground(Color.GREEN); center.setBounds((int) (0), (int) (0), (int) (.6*w), (int) (.6*h));
		//begin set components
		JPanel buttons = new JPanel(); buttons.setBounds(0, 0, (int) (.3*w), (int) (.6*h)); buttons.setLayout(new GridLayout(2,0));
		JLabel label = new JLabel("Edit Curves");
		JButton button = new JButton("Curves");
		button.addActionListener(this);
		button.setActionCommand("edit Curves");
		buttons.add(label);
		buttons.add(button);
		west.add(buttons);
		buttons = new JPanel(); buttons.setBounds(0, 0, (int) (.3*w), (int) (.6*h)); buttons.setLayout(new GridLayout(2,0));
		label = new JLabel("View Stats");
		button = new JButton("Statistics");
		button.addActionListener(this);
		button.setActionCommand("view Company Stats");
		buttons.add(label);
		buttons.add(button);
		west.add(buttons);
		JPanel graph = new JPanel(); graph.setBounds(0,0,(int) (w), (int)(h)); graph.setLayout(new GridLayout(4,0)); graph.setBackground(Color.DARK_GRAY);
		Curve james = new Curve("units (#)","price ($)");
		james.addPoint(1.0, 1.0);
		james.addPoint(3.0, 3.0);
		JGraph graphic = new JGraph(james); graphic.setBackground(Color.MAGENTA); graphic.setBounds(0, 0, (int) (100), (int) (100));
		graph.add(graphic);
		center.add(graph);
		//end set components
		mainLayout.add(north, BorderLayout.NORTH);
		mainLayout.add(south, BorderLayout.SOUTH);
		mainLayout.add(east, BorderLayout.EAST);
		mainLayout.add(west, BorderLayout.WEST);
		mainLayout.add(center, BorderLayout.CENTER);
		//end set layout
		//add content
		//end add content
		//add everything
		this.add(mainLayout);
	}

	public static void main(String[] args)
	{
		MainDisplayPanel sally = new MainDisplayPanel();
		Dimension d = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int w = (int) d.getWidth();
		int h = (int) d.getHeight();
		sally.setBounds((int) (.1*w),(int) (.1*h),(int) (.8*w),(int) (.8*h)); //the first two are the top left corner, then width and height
		sally.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //make sure memory is freed up on close
		sally.setBackground(Color.RED);
		sally.setVisible(true); //makes it finally visible
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		int w = this.getWidth();
		int h = this.getHeight();
		g.setColor(Color.RED);
		for (int i = 0; i<10;i++)
		{
			g.drawLine((int) (0),(int) (i*.1*h), (int) (w), (int) (i*.1*h));
			g.drawLine((int) (i*.1*w),(int) (0), (int) (i*.1*w), (int) (h));
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
