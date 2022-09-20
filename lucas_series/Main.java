
//import
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import java.util.List;

//the Main Class
public class Main extends JFrame {

  // The variables
  private JPanel contentPane;
  private JTextField input;
  JPanel panel;
  JScrollPane scrollPane;
  JLabel labelData;
  JTextArea showData;
  private JButton calcButton;
  private JButton cancButton;
  private JPanel panel_1;
  private JLabel sumLabel;
  private static JProgressBar progressBar;
  int[] list = new int[30];
  int sum = 0;
  int x = 1;

  // constructor
  public Main() {

    // setting of the frame
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 800, 600);
    setVisible(true);

    // Panels
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(new BorderLayout(0, 0));
    panel = new JPanel();
    contentPane.add(panel, BorderLayout.NORTH);

    // the label
    labelData = new JLabel("Number of row in Lucas series: ");
    panel.add(labelData);

    // the input field
    input = new JTextField();
    panel.add(input);
    input.setColumns(10);

    // When clicking the Calculation button
    calcButton = new JButton("Get Sum of Lucas series");
    calcButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        DoCalc();
        DoSum();
      }
    });

    cancButton = new JButton("Cancel");

    // Add the buttons on the window
    panel.add(calcButton);
    panel.add(cancButton);
    cancButton.setEnabled(false); // the cancel button is diabled first

    // add the textarea with the scrollpane
    showData = new JTextArea();
    scrollPane = new JScrollPane(showData);
    contentPane.add(scrollPane, BorderLayout.CENTER);

    panel_1 = new JPanel();
    contentPane.add(panel_1, BorderLayout.SOUTH);

    // progress bar setting
    progressBar = new JProgressBar(0, 100);
    progressBar.setIndeterminate(false);
    progressBar.setStringPainted(true);
    progressBar.setVisible(true);
    panel_1.add(progressBar);

    // the sum of the calculation
    sumLabel = new JLabel("Sum = ");
    panel_1.add(sumLabel);
  }

  private void DoCalc() { // Calculation function

    try { // If input is number, no error.
      int Num = Integer.parseInt(input.getText());
    } catch (Exception e) {
      JOptionPane.showMessageDialog(this, "Enter valid input!", "Warning", JOptionPane.ERROR_MESSAGE);
    }
    int Num = Integer.parseInt(input.getText());

    // first thread
    SwingWorker worker = new SwingWorker<Boolean, Integer>() {

      @Override
      protected Boolean doInBackground() throws Exception { // not on GUI, but the calculation started.

        cancButton.setEnabled(true); // cancel button enabled.
        progressBar.setValue(0);
        showData.setText("");
        list[0] = 2;
        showData.append(list[0] + "\n");
        list[1] = 1;
        showData.append(list[1] + "\n");

        for (int i = 2; i < Num; i++) { // from third numbers, use the for loop to calculate.
          Thread.sleep(200);
          list[i] = list[i - 1] + list[i - 2];
          publish(i); // go to process
        }
        return false;
      }

      @Override
      protected void process(List<Integer> chunks) {

        Integer value = chunks.get(chunks.size() - 1);
        showData.append(list[value] + "\n"); // show on screen
        // progress bar update
        progressBar.setValue(100 / Num * value);
        x = 100 / Num * value;
      }

      @Override
      protected void done() { // put the values into the file
        cancButton.setEnabled(false); // cancel button disabled again after calculation.
        try {
          // file opened
          FileOutputStream fileObject = new FileOutputStream("data.txt", false);
          PrintWriter x = new PrintWriter(fileObject);
          x.print(list[0] + ", ");
          x.print(list[1] + ", ");

          for (int i = 2; i < Num; i++) { // put the values in the list into the file.
            x.print(list[i] + ", ");
          }
          x.close(); // close file
          progressBar.setValue(100);
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        }
      }
    };
    worker.execute(); // start the thread.

    cancButton.addActionListener(new ActionListener() { // the cancel button function
      public void actionPerformed(ActionEvent arg0) {
        worker.cancel(true); // stop the thread
        progressBar.setValue(x); // fix the progress bar value
      }
    });
  }

  private void DoSum() { // the sumLabel's update

    SwingWorker worker2 = new SwingWorker<Boolean, Integer>() { // second thread

      @Override
      protected Boolean doInBackground() throws Exception {
        sum = 0; // the sum is 0 at first.
        int Num = Integer.parseInt(input.getText());
        // if the input is greater than 2.
        if (Num >= 2) {
          sum += 3;
        } else if (Num >= 1) {
          sum += 2;
        }
        // to show the sum on the label
        for (int i = 2; i < Num; i++) {
          Thread.sleep(200);
          publish(i); // go to process
        }
        return false;
      }

      @Override
      protected void process(List<Integer> chunks) {
        Integer value = chunks.get(chunks.size() - 1);
        sum += list[value]; // increase the sum
        sumLabel.setText("Sum = " + sum); // update the label
      }
    };

    worker2.execute(); // start the second thread

    cancButton.addActionListener(new ActionListener() { // after clicking cancel button.
      public void actionPerformed(ActionEvent arg0) {
        worker2.cancel(true); // stop the second thread
      }
    });
  }

  public static void main(String[] args) { // the main function
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        new Main(); // the Main class started.
      }
    });
  }
}