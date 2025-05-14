package Ex8;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Count extends JFrame implements ActionListener {
    int count = 0;
    JLabel label;
    JTextField textField;
    JButton b1, b2, b3;
    
public Count() {
        setLayout(new FlowLayout());
        label = new JLabel("Counter");
        add(label);
        textField = new JTextField("0", 5);
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.CENTER);
        add(textField);

        b1 = new JButton("Count Up");
        b2 = new JButton("Count Down");
        b3 = new JButton("Reset");

        add(b1);
        add(b2);
        add(b3);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        setTitle("Counter");
        setSize(400, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            count++;
        } 
        else if (e.getSource() == b2) {
            count--;
        } 
        else if (e.getSource() == b3) {
            count = 0;
        }
        textField.setText(String.valueOf(count));
    }

    public static void main(String[] args) {
        new Count();
    }
}