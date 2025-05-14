import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BackgroundColorChanger extends JFrame {

    private JButton changeColorButton;

    public BackgroundColorChanger() {
        // Set up the frame
        setTitle("Background Color Changer");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create the button to change color
        changeColorButton = new JButton("Change Background Color");
        changeColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open color chooser dialog
                Color selectedColor = JColorChooser.showDialog(null, "Choose Background Color", getBackground());
                if (selectedColor != null) {
                    // Set the background color of the frame
                    getContentPane().setBackground(selectedColor);
                }
            }
        });

        // Add button to the frame
        add(changeColorButton);

        // Set the frame to be visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Run the program
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BackgroundColorChanger();
            }
        });
    }
}
