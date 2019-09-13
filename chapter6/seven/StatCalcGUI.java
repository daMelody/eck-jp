package chapter6.seven;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import stats.StatCalc;

public class StatCalcGUI extends JPanel implements ActionListener {

  public static void main(String[] args) {
    JFrame window = new JFrame("Statistics Calculator");
    StatCalcGUI content = new StatCalcGUI();
    window.setContentPane(content);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.pack();
    window.setLocation(200,200);
    window.setVisible(true);
  }

  // --------------------------------------------------------------

  private StatCalc calculator;
  private JTextField entry;
  private JLabel numEntries, sum, average, stdd;


  public StatCalcGUI() {
    calculator = new StatCalc();  // construct initial instance
    setBackground(Color.BLACK);
    setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

    // the UI panel
    JPanel entryPanel = new JPanel();
    entryPanel.setLayout(new GridLayout(1,3,1,1));
    entryPanel.add(new JLabel("Entry: "));
    entry = new JTextField("0",10); // create entry text field
    entryPanel.add(entry);
    JButton enter = new JButton("enter");  // enter button
    enter.addActionListener(this);
    entryPanel.add(enter);
    JButton clear = new JButton("clear");  // clear button
    clear.addActionListener(this);
    entryPanel.add(clear);


    // number of entries
    JPanel numEntriesPanel = new JPanel();
    numEntriesPanel.add(new JLabel("Number of Entries: "));
    numEntries = new JLabel("0");
    numEntriesPanel.add(numEntries);


    // sum
    JPanel sumPanel = new JPanel();
    sumPanel.add(new JLabel("Sum: "));
    sum = new JLabel("0.0");
    sumPanel.add(sum);


    // average
    JPanel averagePanel = new JPanel();
    averagePanel.add(new JLabel("Average: "));
    average = new JLabel("undefined");
    averagePanel.add(average);


    // standard deviation
    JPanel stddPanel = new JPanel();
    stddPanel.add(new JLabel("Standard Deviation: "));
    stdd = new JLabel("undefined");
    stddPanel.add(stdd);

    // add all panels to StatCalcGUI
    setLayout(new GridLayout(5,1,2,2));
    add(entryPanel);
    add(numEntriesPanel);
    add(sumPanel);
    add(averagePanel);
    add(stddPanel);
  }


  public void actionPerformed(ActionEvent evt) {
    String op = evt.getActionCommand(); // ENTRY or CLEAR
    if (op.equals("clear")) {  // if CLEAR, reboot the stat calculator
      calculator = new StatCalc();
      System.out.println("cleared");
    } else {
      double entered;
      try { // process the entry value
        entered = Double.parseDouble(entry.getText());
      } catch(NumberFormatException e) {
        stdd.setText("Illegal input.");
        entry.requestFocusInWindow();
        return;
      }
      calculator.enter(entered);
    }
    // update all output labels
    numEntries.setText(String.valueOf(calculator.getCount()));
    sum.setText(String.valueOf(calculator.getSum()));
    average.setText(String.valueOf(calculator.getMean()));
    stdd.setText(String.valueOf(calculator.getStandardDeviation()));
  }
}
