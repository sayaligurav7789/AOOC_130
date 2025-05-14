package Ex8;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Addition extends JFrame implements ActionListener{
    JLabel l1, l2, l3;
    JTextField t1, t2, t3;
    JButton b1;

    public Addition(){
        setTitle("Sum Calculator");
        setLayout(new BorderLayout(10, 10));
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        l1 = new JLabel("Number 1:");
        l2 = new JLabel("Number 2:");
        l3 = new JLabel("Sum Result:");
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);
        t3.setEditable(false);

        inputPanel.add(l1); inputPanel.add(t1);
        inputPanel.add(l2); inputPanel.add(t2);
        inputPanel.add(l3); inputPanel.add(t3);

        // Panel for button (south)
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        b1 = new JButton("Calculate Sum");
        buttonPanel.add(b1);

        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        b1.addActionListener(this);

        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        try{
            int num1 = Integer.parseInt(t1.getText());
            int num2 = Integer.parseInt(t2.getText());
            int sum = num1 + num2;
            t3.setText(String.valueOf(sum));
        } 
        catch (NumberFormatException ex) {
            t3.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        new Addition();
    }
}
