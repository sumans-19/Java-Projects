package Electric.Billing.Port;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {

    String aType, meter;

    Project(String aType, String meter) {
        this.aType = aType;
        this.meter = meter;
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);

        JMenu master = new JMenu("Master");
        master.setForeground(Color.RED);

        JMenuItem newcustomer = new JMenuItem("New Customer");
        newcustomer.setFont(new Font("monospace", Font.BOLD, 12));
        newcustomer.setBackground(Color.WHITE);
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        Image icon2 = icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        newcustomer.setIcon(new ImageIcon(icon2));
        master.add(newcustomer);
        newcustomer.setMnemonic('D');
        newcustomer.addActionListener(this);
        newcustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));

        JMenuItem customerdetails = new JMenuItem("Customer Details");
        customerdetails.setFont(new Font("monospace", Font.BOLD, 12));
        customerdetails.setBackground(Color.WHITE);
        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
        Image icon4 = icon3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        customerdetails.setIcon(new ImageIcon(icon4));
        master.add(customerdetails);
        customerdetails.setMnemonic('M');
        customerdetails.addActionListener(this);
        customerdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));

        JMenuItem depositdetails = new JMenuItem("Deposit Details");
        depositdetails.setFont(new Font("monospace", Font.BOLD, 12));
        depositdetails.setBackground(Color.WHITE);
        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
        Image image6 = icon5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        depositdetails.setIcon(new ImageIcon(image6));
        depositdetails.setMnemonic('N');
        depositdetails.addActionListener(this);
        depositdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        master.add(depositdetails);

        JMenuItem calculatebill = new JMenuItem("Calculate Bill");
        calculatebill.setFont(new Font("monospace", Font.BOLD, 12));
        calculatebill.setBackground(Color.WHITE);
        ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
        Image icon8 = icon7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calculatebill.setIcon(new ImageIcon(icon8));
        master.add(calculatebill);
        calculatebill.setMnemonic('N');
        calculatebill.addActionListener(this);
        calculatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));

        JMenu info = new JMenu("Information");
        info.setForeground(Color.BLUE);

        JMenuItem updateinfo = new JMenuItem("Update Information");
        updateinfo.setFont(new Font("monospace", Font.BOLD, 12));
        updateinfo.setBackground(Color.WHITE);
        ImageIcon icon9 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image icon10 = icon9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        updateinfo.setIcon(new ImageIcon(icon10));
        info.add(updateinfo);
        updateinfo.setMnemonic('P');
        updateinfo.addActionListener(this);
        updateinfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));

        JMenuItem viewinfo = new JMenuItem("View Information");
        viewinfo.setFont(new Font("monospace", Font.BOLD, 12));
        viewinfo.setBackground(Color.WHITE);
        ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image icon12 = icon11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        viewinfo.setIcon(new ImageIcon(icon12));
        info.add(viewinfo);
        viewinfo.setMnemonic('J');
        viewinfo.addActionListener(this);
        viewinfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, ActionEvent.CTRL_MASK));

        JMenu user = new JMenu("User");
        user.setForeground(Color.RED);

        JMenuItem paybill = new JMenuItem("Pay Bill");
        paybill.setFont(new Font("monospace", Font.BOLD, 12));
        paybill.setBackground(Color.WHITE);
        ImageIcon icon13 = new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
        Image icon14 = icon13.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        paybill.setIcon(new ImageIcon(icon14));
        user.add(paybill);
        paybill.setMnemonic('S');
        paybill.addActionListener(this);
        paybill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));

        JMenuItem billdetails = new JMenuItem("Bill Details");
        billdetails.setFont(new Font("monospace", Font.BOLD, 12));
        billdetails.setBackground(Color.WHITE);
        ImageIcon icon15 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image icon16 = icon15.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        billdetails.setIcon(new ImageIcon(icon16));
        user.add(billdetails);
        billdetails.addActionListener(this);
        billdetails.setMnemonic('O');
        billdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));

        JMenu report = new JMenu("Report");
        report.setForeground(Color.BLUE);

        JMenuItem generatebill = new JMenuItem("Generate Bill");
        generatebill.setFont(new Font("monospace", Font.BOLD, 12));
        generatebill.setBackground(Color.WHITE);
        ImageIcon icon17 = new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
        Image icon18 = icon17.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        generatebill.setIcon(new ImageIcon(icon18));
        report.add(generatebill);
        generatebill.setMnemonic('G');
        generatebill.addActionListener(this);
        generatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));

        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.RED);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setFont(new Font("monospace", Font.BOLD, 12));
        notepad.setBackground(Color.WHITE);
        ImageIcon icon19 = new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
        Image icon20 = icon19.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(icon20));
        notepad.addActionListener(this);

        utility.add(notepad);
        notepad.setMnemonic('Q');
        notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));

        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setFont(new Font("monospace", Font.BOLD, 12));
        calculator.setBackground(Color.WHITE);
        ImageIcon icon21 = new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
        Image icon22 = icon21.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calculator.setIcon(new ImageIcon(icon22));
        calculator.addActionListener(this);
        utility.add(calculator);
        calculator.setMnemonic('P');
        calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));

        JMenu mexit = new JMenu("Exit");
        mexit.setForeground(Color.BLUE);

        JMenuItem exit = new JMenuItem("Exit");
        exit.setFont(new Font("monospace", Font.BOLD, 12));
        exit.setBackground(Color.WHITE);
        ImageIcon icon23 = new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        Image icon24 = icon23.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        exit.setIcon(new ImageIcon(icon24));
        mexit.add(exit);
        exit.addActionListener(this);
        exit.setMnemonic('W');
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));

        if (aType.equals("Admin")) {
            mb.add(master);
        } else {
            mb.add(info);
            mb.add(user);
            mb.add(report);
        }
        mb.add(utility);
        mb.add(mexit);

        setLayout(new FlowLayout());

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        if (msg.equals("New Customer")) {
            new NewCustomer();
        } else if (msg.equals("Customer Details")) {
            new CustomerDetails();
        } else if (msg.equals("Deposit Details")) {
            new DepositDetails();
        } else if (msg.equals("Calculate Bill")) {
            new CalculateBill();
        } else if (msg.equals("View Information")) {
            new ViewInformation(meter);
        } else if (msg.equals("Update Information")) {
            new UpdateInformation(meter);
        } else if (msg.equals("Bill Details")) {
            new BillDetails(meter);
        } else if (msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (msg.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (msg.equals("Exit")) {
            setVisible(false);
            new Login();
        } else if (msg.equals("Pay Bill")) {
            new PayBill(meter);
        } else if (msg.equals("Generate Bill")) {
            new GenerateBill(meter);
        }
    }

    public static void main(String[] args) {
        new Project("", "");
    }

}
