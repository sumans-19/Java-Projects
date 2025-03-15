package Electric.Billing.Port; // Package declaration

import javax.swing.*; // Importing Swing components for GUI
import java.awt.*; // Importing AWT components for layout and colors
import java.awt.event.*;
import java.sql.*;

// Creating a Login class that extends JFrame (used for creating a window in Swing)
public class Login extends JFrame implements ActionListener {

    JButton login, cancel, signup;
    JTextField username, password;
    Choice loggingin;

    // Constructor for Login class
    Login() {
        super("Login Page"); // Setting title for JFrame, must be the first line in constructor

        getContentPane().setBackground(Color.WHITE); // Setting background color of frame to white
        setLayout(null); // Using null layout for manual component positioning

        // Creating and positioning "UserName" label
        JLabel lblUsername = new JLabel("UserName : ");
        lblUsername.setBounds(300, 20, 100, 20);
        add(lblUsername);

        // Creating text field for username input
        username = new JTextField();
        username.setBounds(400, 20, 150, 20);
        add(username);

        // Creating and positioning "Password" label
        JLabel lblPassword = new JLabel("Password : ");
        lblPassword.setBounds(300, 60, 100, 20);
        add(lblPassword);

        // Creating text field for password input (should use JPasswordField for security)
        password = new JTextField();
        password.setBounds(400, 60, 150, 20);
        add(password);

        // Creating and positioning "Logging in as" label
        JLabel logininas = new JLabel("Logging in as: ");
        logininas.setBounds(300, 100, 100, 20);
        add(logininas);

        // Creating dropdown (Choice) for selecting login role (Admin/Customer)
        loggingin = new Choice();
        loggingin.add("Admin");
        loggingin.add("Customer");
        loggingin.setBounds(400, 100, 150, 20);
        add(loggingin);

        // Adding Login button with icon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png")); // Load image
        Image i2 = i1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT); // Resize image
        login = new JButton("Login", new ImageIcon(i2)); // Create button with icon
        login.setBounds(330, 160, 100, 25);
        login.addActionListener(this);
        add(login);

        // Adding Cancel button with icon
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        Image i4 = i3.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        cancel = new JButton("Cancel", new ImageIcon(i4));
        cancel.setBounds(450, 160, 100, 25);
        cancel.addActionListener(this);
        add(cancel);

        // Adding Signup button with icon
        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image i6 = i5.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        signup = new JButton("Signup", new ImageIcon(i6));
        signup.setBounds(380, 200, 100, 25);
        signup.addActionListener(this);
        add(signup);

        // Adding an image to the left side of the login window
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i8 = i7.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT); // Resize image
        ImageIcon i9 = new ImageIcon(i8);
        JLabel image = new JLabel(i9);
        image.setBounds(10, 0, 250, 250);
        add(image);

        // Setting the frame size
        setSize(640, 300);
        setLocation(400, 200); // Positioning the window on the screen
        setVisible(true); // Making the frame visible

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String susername = username.getText();
            String spassword = password.getText();
            String user = loggingin.getSelectedItem();

            try {
                conn c = new conn();
                String query = "select * from login where username = '"+susername+"'and password = '"+spassword+"' and  user = '"+user+"'";
                
               
                ResultSet rs =  c.s.executeQuery(query);
                
                if(rs.next()){
                    String meter = rs.getString("meter_no");
                    setVisible(false);
                    new Project(user,meter);
                
                }else{
                JOptionPane.showMessageDialog(null,"Invalid Login");
                username.setText("");
                password.setText("");
                }
                
            } catch (Exception e) {
                
                e.printStackTrace();
                
            }

        } else if (ae.getSource() == cancel) {
            setVisible(false);
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new Signup();
        }
    }

    // Main method to launch the login window
    public static void main(String rgs[]) {
        new Login(); // Creating an instance of Login class
    }
}
