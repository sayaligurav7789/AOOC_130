package Ex8;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Simple_Form extends JFrame implements ActionListener {

    JLabel lblName, lblEmail, lblGender;
    JTextField txtName, txtEmail;
    JRadioButton rbMale, rbFemale;
    JButton btnSubmit, btnClear;
    ButtonGroup bg;

    public Simple_Form() {
        setTitle("Simple Form");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblName = new JLabel("Name:");
        txtName = new JTextField();

        lblEmail = new JLabel("Email:");
        txtEmail = new JTextField();

        lblGender = new JLabel("Gender:");
        rbMale = new JRadioButton("Male");
        rbFemale = new JRadioButton("Female");
        bg = new ButtonGroup();
        bg.add(rbMale);
        bg.add(rbFemale);

        btnSubmit = new JButton("Submit");
        btnClear = new JButton("Clear");

        btnSubmit.addActionListener(this);
        btnClear.addActionListener(this);

        add(lblName);
        add(txtName);

        add(lblEmail);
        add(txtEmail);

        add(lblGender);
        JPanel genderPanel = new JPanel(new FlowLayout());
        genderPanel.add(rbMale);
        genderPanel.add(rbFemale);
        add(genderPanel);

        add(btnSubmit);
        add(btnClear);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {
            String name = txtName.getText();
            String email = txtEmail.getText();
            String gender = rbMale.isSelected() ? "Male" :
                            rbFemale.isSelected() ? "Female" : "Not selected";

            JOptionPane.showMessageDialog(this,
                "Name: " + name + "\nEmail: " + email + "\nGender: " + gender);
        } else if (e.getSource() == btnClear) {
            txtName.setText("");
            txtEmail.setText("");
            bg.clearSelection();
        }
    }

    public static void main(String[] args) {
        new Simple_Form();
    }
}
