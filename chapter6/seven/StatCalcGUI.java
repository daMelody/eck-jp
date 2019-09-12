package chapter6.seven;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StatCalcGUI extends JPanel implements MouseListener {

  private StatCalc calculator;

  public static void main(String[] args) {
    JFrame window = new JFrame("Statistics Calculator");
    StatCalcGUI content = new StatCalcGUI();
    window.setContentPane(content);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setSize(500,500);
    window.setLocation(200,200);
    window.setVisible(true);
  }

  // --------------------------------------------------------------

  public StatCalcGUI() {
    setBackground(Color.BLACK);
    addMouseListener(this)
  }
}
