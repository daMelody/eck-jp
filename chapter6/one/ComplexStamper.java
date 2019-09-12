package chapter6.one;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComplexStamper extends JPanel implements MouseListener, MouseMotionListener {

	private int startX, startY;
	private int prevX, prevY;
	private boolean dragging;

	public static void main(String[] args) {
		JFrame window = new JFrame("Complex Stamper");
		ComplexStamper content = new ComplexStamper();
		window.setContentPane(content);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocation(120,70);
		window.setSize(400,300);
		window.setVisible(true);
	}

	// -------------------------------------------------
	
	public ComplexStamper() {
		setBackground(Color.BLACK);
		addMouseListener(this);
		addMouseMotionListener(this);
	}


	public void mousePressed(MouseEvent evt) {
		if (evt.isShiftDown()) {
			repaint();
			return;
		}
		startX = evt.getX(); // where mouse is clicked
		startY = evt.getY(); // where mouse is clicked
		prevX = startX; prevY = startY;
		Graphics g = getGraphics();
		// right click
		if (SwingUtilities.isRightMouseButton(evt)) {
			g.setColor(Color.BLUE);
			g.fillOval(startX-30,startY-15,60,30);
			g.setColor(Color.WHITE);
			g.drawOval(startX-30,startY-15,60,30);
		} else { // left click
			g.setColor(Color.RED);
			g.fillRect(startX-30,startY-15,60,30);
			g.setColor(Color.WHITE);
			g.drawRect(startX-30,startY-15,60,30);
		}
		g.dispose();
	}


	public void mouseEntered(MouseEvent evt) {}
	public void mouseExited(MouseEvent evt) {}
	public void mouseClicked(MouseEvent evt) {}

	public void mouseReleased(MouseEvent evt) {
		if (dragging) {
			return;
		}
		dragging = false;
	}

	// methods from MouseMotionListener
	public void mouseDragged(MouseEvent evt) {
		int x = evt.getX(); int y = evt.getY();
		// check that DELTA in either direction is >= 5
		if ((Math.abs(x-prevX) >= 5) || (Math.abs(y-prevY) >= 5)) {
			Graphics g = getGraphics();  // get the graphics object
			// right click
			if (SwingUtilities.isRightMouseButton(evt)) {
				g.setColor(Color.BLUE);
				g.fillOval(x-30,y-15,60,30);
				g.setColor(Color.WHITE);
				g.drawOval(x-30,y-15,60,30);
			} else {  // left click
				g.setColor(Color.RED);
				g.fillRect(x-30,y-15,60,30);
				g.setColor(Color.WHITE);
				g.drawRect(x-30,y-15,60,30);
			}
			g.dispose();	
			// reassign prevX and prevY
			prevX = x; prevY = y;
		}
	}	
	
	public void mouseMoved(MouseEvent evt) {}
}
