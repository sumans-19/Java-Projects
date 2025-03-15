package Electric.Billing.Port;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {

    Thread t; // Thread for controlling the splash screen duration

    // Constructor to initialize the splash screen
    Splash() {
        super("Welcome Page");
        // Load and scale the splash image
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icon/elect.png"));
        Image i2 = il.getImage().getScaledInstance(1000, 563, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        // Add image to a JLabel and set it on the frame
        JLabel image = new JLabel(i3); // JLabel can display both text and images
        add(image);

        // Make the splash screen visible
        setVisible(true);

        // Animation effect: gradually increase window size
        int x = 1;
        for (int i = 2; i < 600; i += 4, x += 1) {
            setSize(i + x, i); // Dynamically change frame size
            setLocation(720 - ((i + x) / 2), 400 - (i / 2)); // Center the frame
            try {
                Thread.sleep(5); // Small delay to create a smooth animation
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        // Start a separate thread for controlling splash screen duration
        t = new Thread(this);
        t.start();
        
        setVisible(true); // Ensure the splash screen remains visible
    }

    // Method executed by the thread
    public void run() {
        try {
            Thread.sleep(5000); // Keep splash screen visible for 5 seconds
            setVisible(false);  // Hide the splash screen
            
            // TODO: Open the login frame after splash screen closes
            // new LoginFrame();
            new Login();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Main method to start the splash screen
    public static void main(String[] args) {
        new Splash();
    }
}
