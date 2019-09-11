package chapter6.one;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComplexStamper extends JPanel implements MouseListener, MouseMotionListener {

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
	}


	public void mousePressed(MouseEvent evt) {
		if (evt.isShiftDown()) {
			repaint();
			return;
		}
		int x = evt.getX(); // where mouse is clicked
		int y = evt.getY(); // where mouse is clicked
		Graphics g = getGraphics();
		if (SwingUtilities.isRightMouseButton(evt)) {
			g.setColor(Color.BLUE);
			g.fillOval(x-30,y-15,60,30);
			g.setColor(Color.WHITE);
			g.drawOval(x-30,y-15,60,30);
		} else {
			g.setColor(Color.RED);
			g.fillRect(x-30,y-15,60,30);
			g.setColor(Color.WHITE);
			g.drawRect(x-30,y-15,60,30);
		}
		g.dispose();
	}


	public void mouseEntered(MouseEvent evt) {}
	public void mouseExited(MouseEvent evt) {}
	public void mouseClicked(MouseEvent evt) {}
	public void mouseReleased(MouseEvent evt) {}

	// methods from MouseMotionListener
	public void mouseMoved(MouseEvent evt) {}
	public void mouseDragged(MouseEvent evt) {}
}
