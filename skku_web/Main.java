import java.awt.*; //import awt
import javax.swing.*; //import swing

/*For ActionKListener */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener { // the main function with extension of JFrame and
                                                             // ActionListener.
  /* the Img used in the code */
  Icon wallpaperImg = new ImageIcon(getClass().getResource("pictures/skku_wallpaper.png"));
  Icon titleImg = new ImageIcon(getClass().getResource("pictures/title_label.png"));

  /* Panel used in the program */
  private JPanel leftPanel = new JPanel(); // the left panel
  private JPanel rightPanel = new JPanel(); // the right panel

  /* Label and message used in the program */
  private JLabel label1 = new JLabel(wallpaperImg);
  private JLabel label2 = new JLabel(titleImg);
  private JLabel label3 = new JLabel("");
  private JLabel message1 = new JLabel("Application Name:");
  private JLabel message2 = new JLabel("Birth Date:");
  private JLabel message3 = new JLabel("Email:");
  private JLabel message4 = new JLabel("Degree:");
  private JLabel message5 = new JLabel("Attended university (for Graduates):");
  private JLabel message6 = new JLabel("GPA (for Graduates):");
  private JLabel message7 = new JLabel("Phone Number:");
  private JLabel message8 = new JLabel("Experience:");
  private JLabel message9 = new JLabel("Personal Statement", SwingConstants.CENTER);
  private JLabel message10 = new JLabel("Home Address: ");

  /* TextBox in the code */
  private JTextField text1 = new JTextField();
  private JTextField text2 = new JTextField();
  private JTextField text3 = new JTextField();
  private JTextField text4 = new JTextField();
  private JTextField text5 = new JTextField();
  private JTextField text6 = new JTextField();
  private JTextField text7 = new JTextField();
  private JTextField text8 = new JTextField();
  private JTextField text9 = new JTextField("At least 100 words...");
  private JTextField text10 = new JTextField();

  /* the submit button */
  private JButton button1 = new JButton("Submit Application");

  public Main() { // main function

    setSize(800, 700); // size of the frame
    setLayout(new FlowLayout()); // the flow of the components
    setTitle("SKKU New Students Enrollment"); // the title on the frame
    setDefaultCloseOperation(EXIT_ON_CLOSE); // the X button on the top

    text9.setPreferredSize(new Dimension(100, 100)); // the size of the text
    rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS)); // Having the components in box layout.
    leftPanel.setBackground(Color.YELLOW); // the background color of the image on the left side.
    rightPanel.setBackground(Color.GREEN); // the background color of the right side.

    /* Setting of the Labels on right side */
    message1.setFont(new Font("Serif", Font.PLAIN, 20));
    message2.setFont(new Font("Serif", Font.PLAIN, 20));
    message3.setFont(new Font("Serif", Font.PLAIN, 20));
    message4.setFont(new Font("Serif", Font.PLAIN, 20));
    message5.setFont(new Font("Serif", Font.PLAIN, 20));
    message6.setFont(new Font("Serif", Font.PLAIN, 20));
    message7.setFont(new Font("Serif", Font.PLAIN, 20));
    message8.setFont(new Font("Serif", Font.PLAIN, 20));
    message9.setFont(new Font("Serif", Font.PLAIN, 20));
    message10.setFont(new Font("Serif", Font.PLAIN, 20));

    // adding the components onto the window.
    add(leftPanel);
    add(rightPanel);
    leftPanel.add(label1);
    rightPanel.add(label2);
    rightPanel.add(label3);
    rightPanel.add(message1);
    rightPanel.add(text1);
    rightPanel.add(message2);
    rightPanel.add(text2);
    rightPanel.add(message3);
    rightPanel.add(text3);
    rightPanel.add(message4);
    rightPanel.add(text4);
    rightPanel.add(message5);
    rightPanel.add(text5);
    rightPanel.add(message6);
    rightPanel.add(text6);
    rightPanel.add(message7);
    rightPanel.add(text7);
    rightPanel.add(message8);
    rightPanel.add(text8);
    rightPanel.add(message9);
    rightPanel.add(text9);
    rightPanel.add(message10);
    rightPanel.add(text10);
    rightPanel.add(button1);

    // Adding the actionlistener of the button.
    button1.addActionListener(this);

    // visualize the window
    setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    /* to get text from the text field */
    String output = new String();
    String string1 = text1.getText();
    String string2 = text2.getText();
    String string3 = text3.getText();
    String string4 = text4.getText();
    String string5 = text5.getText();
    String string6 = text6.getText();
    String string7 = text7.getText();
    String string8 = text8.getText();
    String string9 = text9.getText();
    String string10 = text10.getText();

    // to make a string array to check how many words and string9.
    String[] words = string9.trim().split("\\s+");

    if (e.getSource() == button1) { // When clicking button1

      /* Exception */
      if (string1.isEmpty()) { // empty text
        output += "-You forgot to fill the name text field, Please fill it. \n";
      } else if (string1.contains(" ") == false) { // no space
        output += "-You forgot to write your name or surname. \n";
      }

      if (string2.isEmpty()) { // empty text
        output += "-You forgot to fill the Birth Date text field, Please fill it. \n";
      } else if (string2.contains("/") == false) { // no '/' in the format
        output += "-Birthdate must be in '06/06/1995' format. \n";
      }

      if (string3.isEmpty()) { // empty text
        output += "-You forgot to fill the Email text field, Please fill it. \n";
      } else if (string3.contains("@") && string3.contains(".") == false) { // without '@' and '.'
        output += "-Email must be in example@some.some. \n";
      }

      if (string4.isEmpty()) { // empty text
        output += "-You forgot to fill the Degree text field, Please fill it. \n";
      } else if (string4 == "PhD" && (string5.isEmpty() || string6.isEmpty())) { // PhD students (graduate) has not put
                                                                                 // the previous school or GPA.
        output += "-For graduate, you have to enter previous university and GPA \n";
        if (string6.isEmpty() == false) { // if there is input for GPA, check the range.
          float f6 = Float.parseFloat(string6);
          if (f6 < 0 || f6 > 4.5) {
            output += "-GPA must be between 0 and 4.5 \n";
          }
        }

      }

      if (string7.isEmpty()) { // Empty text
        output += "-You forgot to fill the phone number text field, Please fill it. \n";
      } else if (string7.contains("@") || string4.contains("!") || string4.contains("#") || string4.contains("$") ||
          string4.contains("%") || string4.contains("^") || string4.contains("&") || string4.contains("*") ||
          string4.contains("(") || string4.contains(")") || string4.contains("-") || string4.contains("+") ||
          string4.contains("=") || string4.contains("~") || string4.contains("`") || string4.contains(",") ||
          string4.contains(".") || string4.contains("/") || string4.contains("?") || string4.contains(":") ||
          string4.contains(";")) { // if one of the symbols included, error.
        output += "-Proper format for a Phone Number is ‘10 2158 0222. \n";
      }

      if (string8.isEmpty()) { // empty text
        output += "-You forgot to fill the Experience text field, Please fill it. \n";
      }

      if (string9.isEmpty()) { // empty text
        output += "-You forgot to fill the Personal Statement text field, Please fill it. \n";
      } else if (words.length < 100) { // the word length is smaller than 100
        output += "-Your Personal Statement must be at least 100 words. \n";
      }

      if (string10.isEmpty()) { // empty text
        output += "-You forgot to fill the Home Address text field, Please fill it. \n";
      }
    }
    // the popup meesage
    if (output.isEmpty()) {
      JOptionPane.showMessageDialog(this, "Successfully Submitted");
    } else {
      JOptionPane.showMessageDialog(this, output, "You have following problems: ", JOptionPane.ERROR_MESSAGE);
    }

    output = ""; // initialize the output for next click
  }

  public static void main(String[] args) {
    Main main = new Main(); // calling the main
  }
}