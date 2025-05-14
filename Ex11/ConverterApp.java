import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConverterApp extends JFrame implements ActionListener {
    private JTextField inputField, resultField;
    private JButton binaryBtn, octalBtn, hexBtn;

    public ConverterApp() {
        setTitle("Number Converter");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Enter the number"));
        inputField = new JTextField(15);
        topPanel.add(inputField);
        add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(1, 3));
        binaryBtn = new JButton("Binary");
        octalBtn = new JButton("Octal");
        hexBtn = new JButton("Hex");
        centerPanel.add(binaryBtn);
        centerPanel.add(octalBtn);
        centerPanel.add(hexBtn);
        add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(new JLabel("Result"));
        resultField = new JTextField(15);
        resultField.setEditable(false);
        bottomPanel.add(resultField);
        add(bottomPanel, BorderLayout.SOUTH);
        binaryBtn.addActionListener(this);
        octalBtn.addActionListener(this);
        hexBtn.addActionListener(this);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        String input = inputField.getText().trim();
        try {
            int number = Integer.parseInt(input);
            if (e.getSource() == binaryBtn) {
                resultField.setText(Integer.toBinaryString(number));
            } else if (e.getSource() == octalBtn) {
                resultField.setText(Integer.toOctalString(number));
            } else if (e.getSource() == hexBtn) {
                resultField.setText(Integer.toHexString(number).toUpperCase());
            }
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid number");
        }
    }
    public static void main(String[] args) {
        new ConverterApp();
    }
}
