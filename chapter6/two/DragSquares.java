package chapter6.two;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DragSquares extends JPanel implements MouseListener, MouseMotionListener {
	
	private int rectX = 50;
	private int rectY = 50;
	private int ovalX = 200;
	private int ovalY = 50;
	private int sizeRect = 100;
	private int sizeOval = 100;

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
		g.fillRect(rectX,rectY,sizeRect,sizeRect);
		g.setColor(Color.WHITE);
		g.drawRect(rectX,rectY,sizeRect,sizeRect);
		// draw oval
		g.setColor(Color.BLUE);
		g.fillOval(ovalX,ovalY,sizeOval,sizeOval);
		g.setColor(Color.WHITE);
		g.drawOval(ovalX,ovalY,sizeOval,sizeOval);
	}
		
	
	// MouseListener methods
	public void mousePressed(MouseEvent evt) {}
	public void mouseClicked(MouseEvent evt) {}
	public void mouseReleased(MouseEvent evt) {}
	public void mouseEntered(MouseEvent evt) {}
	public void mouseExited(MouseEvent evt) {}
	// MouseMotionListener methods
	public void mouseDragged(MouseEvent evt) {}
	public void mouseMoved(MouseEvent evt) {}

}
