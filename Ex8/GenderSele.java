package Ex8;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GenderSele extends JFrame implements ActionListener{

    JRadioButton maleButton, femaleButton, otherButton;
    JButton submitButton;
    JLabel resultLabel;

    public GenderSele(){
        setLayout(new FlowLayout());

        add(new JLabel("Select your gender:"));

        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        otherButton = new JRadioButton("Other");

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        genderGroup.add(otherButton);

        add(maleButton);
        add(femaleButton);
        add(otherButton);

        submitButton = new JButton("Submit");
        add(submitButton);

        resultLabel = new JLabel("");
        add(resultLabel);

        submitButton.addActionListener(this);

        setTitle("Gender Selection");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        String gender = "";

        if (maleButton.isSelected()) {
            gender = "Male";
        } 
        else if (femaleButton.isSelected()){
            gender = "Female";
        } 
        else if (otherButton.isSelected()){
            gender = "Other";
        }

        if (!gender.isEmpty()){
            resultLabel.setText("Selected Gender: " + gender);
        } 
        else {
            JOptionPane.showMessageDialog(this, "Please select a gender.");
        }
    }

    public static void main(String[] args){
        new GenderSele();
    }
}
