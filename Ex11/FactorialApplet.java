import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class FactorialApplet extends Applet implements ActionListener {
    Label label;
    TextField inputField;
    Button computeButton;
    String result = "";

    public void init() {
        label = new Label("Enter a number:");
        inputField = new TextField(10);
        computeButton = new Button("Find Factorial");

        add(label);
        add(inputField);
        add(computeButton);

        computeButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int num = Integer.parseInt(inputField.getText());
            long fact = 1;

            for (int i = 1; i <= num; i++) {
                fact *= i;
            }

            result = "Factorial of " + num + " is: " + fact;
        } catch (NumberFormatException ex) {
            result = "Invalid input!";
        }

        repaint();
    }
    public void paint(Graphics g) {
        g.drawString(result, 20, 120);
    }
}
