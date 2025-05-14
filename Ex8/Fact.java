package Ex8;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.math.BigInteger;
import javax.swing.*;
class Fact extends JFrame implements ActionListener{
    JLabel l1, l2;
    JTextField t1, t2;
    JButton b1;

    public Fact(){
        setTitle("Factorial Calculator");
        setLayout(new FlowLayout());
        l1 = new JLabel("Enter a number:");
        l2 = new JLabel("Factorial:");
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t2.setEditable(false);
        b1 = new JButton("Calculate");

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(b1);

        b1.addActionListener(this);
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        int num;
        num = Integer.parseInt(t1.getText());
        BigInteger fact = BigInteger.ONE;
        for(int i = 1; i <= num; i++){
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        t2.setText(String.valueOf(fact));
    }
    public static void main(String[] args) {
        new Fact();
    }
}
