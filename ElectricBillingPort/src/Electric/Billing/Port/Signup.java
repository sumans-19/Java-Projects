
package Electric.Billing.Port;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Signup extends JFrame implements ActionListener {

    JButton create, back;
    Choice accountType;
    JTextField meter, username, user, password;

    Signup() {
        // Setting window size and position
        setBounds(450, 150, 700, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null); // Using manual layout

        // Creating a panel with a border
        JPanel panel = new JPanel();
        panel.setBounds(30, 30, 650, 300);
        panel.setBorder(new TitledBorder(
                new LineBorder(new Color(173, 216, 230), 3), // Border color and thickness
                "Create Account", // Title text
                TitledBorder.LEADING, // Title position
                TitledBorder.TOP, // Title alignment
                new Font("Tahoma", Font.BOLD, 16), // Title font
                new Color(0, 102, 204) // Title color
        ));
        panel.setBackground(Color.WHITE);
        panel.setForeground(new Color(34, 139, 34));
        panel.setLayout(null); // Setting layout to null for manual positioning
        add(panel);

        JLabel heading = new JLabel("Create Account As:");
        heading.setBounds(100, 50, 140, 20);
        heading.setForeground(Color.GRAY);
        heading.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(heading);

        accountType = new Choice();
        accountType.add("Admin");
        accountType.add("Customer");
        accountType.setBounds(260, 50, 150, 20);
        panel.add(accountType);

        JLabel lblmeter = new JLabel("Meter Number: ");
        lblmeter.setBounds(100, 90, 140, 20);
        lblmeter.setForeground(Color.GRAY);
        lblmeter.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblmeter.setVisible(false);
        panel.add(lblmeter);

        JLabel lblusername = new JLabel("User Name:");
        lblusername.setBounds(100, 130, 140, 20);
        lblusername.setForeground(Color.GRAY);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblusername);

        username = new JTextField();
        username.setBounds(260, 130, 150, 20);
        panel.add(username);

        JLabel lbluser = new JLabel("Name:");
        lbluser.setBounds(100, 170, 140, 20);
        lbluser.setForeground(Color.GRAY);
        lbluser.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lbluser);

        user = new JTextField();
        user.setBounds(260, 170, 150, 20);
        panel.add(user);

        meter = new JTextField();
        meter.setBounds(260, 90, 150, 20);
        meter.setVisible(false);
        panel.add(meter);

        meter.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
            }

            @Override
            public void focusLost(FocusEvent fe) {
                try {
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("select * from login where meter_no = '" + meter.getText() + "'");
                    while (rs.next()) {
                        user.setText(rs.getString("name"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        JLabel lblpassword = new JLabel("Password:");
        lblpassword.setBounds(100, 210, 140, 20);
        lblpassword.setForeground(Color.GRAY);
        lblpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblpassword);

        password = new JTextField();
        password.setBounds(260, 210, 150, 20);
        panel.add(password);

        accountType.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ar) {
                String users = accountType.getSelectedItem();
                if (users.equals("Customer")) {
                    lblmeter.setVisible(true);
                    meter.setVisible(true);
                    user.setEditable(false);

                } else {
                    lblmeter.setVisible(false);
                    meter.setVisible(false);
                    user.setEditable(true);
                }
            }
        });

        create = new JButton("Create");
        create.setBackground(Color.BLACK);
        create.setForeground(Color.WHITE);
        create.setBounds(140, 260, 120, 25);
        create.addActionListener(this);
        panel.add(create);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(300, 260, 120, 25);
        back.addActionListener(this);
        panel.add(back);

        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
        Image i2 = il.getImage().getScaledInstance(230, 230, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(410, 30, 250, 250);
        panel.add(image);

        setVisible(true); // Making the frame visible
    }

   public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == create) {
            String atype = accountType.getSelectedItem();
            String susername = username.getText();
            String sname = user.getText();
            String spassword = password.getText();
            String smeter = meter.getText();
           
            try {
                conn c = new conn();
                
                String query = null;
                if (atype.equals("Admin")) {
                    query = "insert into login values('"+smeter+"', '"+susername+"', '"+sname+"', '"+spassword+"', '"+atype+"')";
                } else {
                    query = "update login set username = '"+susername+"', password = '"+spassword+"', user = '"+atype+"' where meter_no = '"+smeter+"'";
                }
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                
                setVisible(false);
                new Login();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            
            new Login();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
