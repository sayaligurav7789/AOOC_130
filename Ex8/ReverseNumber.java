package Ex8;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ReverseNumber extends JFrame implements ActionListener{

    JLabel label;
    JTextField inputField, resultField;
    JButton reverseButton;

    public ReverseNumber(){
        setLayout(new FlowLayout());

        label = new JLabel("Enter a number:");
        add(label);

        inputField = new JTextField(10);
        add(inputField);

        reverseButton = new JButton("Find Reverse");
        add(reverseButton);

        resultField = new JTextField(15);
        resultField.setEditable(false);
        resultField.setHorizontalAlignment(JTextField.CENTER);
        add(resultField);

        reverseButton.addActionListener(this);

        setTitle("Reverse Number");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        try{
            int num = Integer.parseInt(inputField.getText());
            int reversed = 0;
            int original = num;

            while (num != 0){
                int digit = num % 10;
                reversed = reversed * 10 + digit;
                num /= 10;
            }

            resultField.setText("Reversed: " + reversed);
        } 
        catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Please enter a valid integer.");
        }
    }

    public static void main(String[] args) {
        new ReverseNumber();
    }
}
