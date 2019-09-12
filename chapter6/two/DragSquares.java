package chapter6.two;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DragSquares extends JPanel implements MouseListener, MouseMotionListener {
	
	private double rectX = 50; // x-coord of rect
	private double rectY = 50; // y-coord of rect
	private double ovalX = 200; // x-coord of oval
	private double ovalY = 50; // y-coord of oval
	private int size = 100; // size of shapes
	private boolean onRect = false; // mouse-click on rect
	private boolean onOval = false; // mouse-click on oval


	public static void main(String[] args) {
		JFrame window = new JFrame("DragSquares");
		DragSquares content = new DragSquares();
		window.setContentPane(content);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocation(120,70);
		window.setSize(450,350);
		window.setVisible(true);
	}

	public DragSquares() {
		setBackground(Color.BLACK);
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g); // color background
		int width = getWidth(); // width of component
		int height = getHeight(); // height of component
		// draw rectangle
		g.setColor(Color.RED);
		g.fillRect((int) rectX,(int) rectY,size,size);
		g.setColor(Color.WHITE);
		g.drawRect((int) rectX,(int) rectY,size,size);
		// draw oval
		g.setColor(Color.BLUE);
		g.fillOval((int) ovalX,(int) ovalY,size,size);
		g.setColor(Color.WHITE);
		g.drawOval((int) ovalX,(int) ovalY,size,size);
	}
		
	
	// MouseListener methods
	public void mousePressed(MouseEvent evt) { 
		double x = evt.getPoint().getX();
		double y = evt.getPoint().getY();
		// rectangle has been clicked
		if (x >= rectX && x <= (rectX+size) && y >= rectY && y <= (rectY+size)) {
			onRect = true;
			return;
		}
		// oval has been clicked
		if (x >= ovalX && x <= (ovalX+size) && y >= ovalY && y <= (ovalY+size)) {
			onOval = true;
			return;
		}
	}
	
	public void mouseReleased(MouseEvent evt) {
		// reset the booleans
		onRect = false; onOval = false;
	}

	public void mouseClicked(MouseEvent evt) {}
	public void mouseEntered(MouseEvent evt) {}
	public void mouseExited(MouseEvent evt) {}
	
	// MouseMotionListener methods
	public void mouseDragged(MouseEvent evt) {
		double x = evt.getX();
		double y = evt.getY();
		if (onRect && (Math.abs(y-rectY) >= 3 || Math.abs(x-rectX) >= 3)) {
			rectX = x;
			rectY = y;
			repaint();
			return;
		}
		if (onOval && (Math.abs(y-ovalY) >= 3 || Math.abs(x-ovalX) >= 3)) {
			ovalX= x;
			ovalY = y;
			repaint();
			return;
		}
	}
	public void mouseMoved(MouseEvent evt) {}

}
