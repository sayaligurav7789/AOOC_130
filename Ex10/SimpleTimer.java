import java.awt.event.*;
import javax.swing.*;

public class SimpleTimer extends JFrame {
    private JLabel timeLabel;
    private JButton startButton, stopButton;
    private Timer timer;
    private int seconds = 0;

    public SimpleTimer() {
        setTitle("Simple Timer");
        setSize(300, 150);
        setLayout(null);

        timeLabel = new JLabel("Time: 0 seconds");
        timeLabel.setBounds(90, 20, 150, 30);
        add(timeLabel);

        startButton = new JButton("Start");
        startButton.setBounds(40, 70, 90, 30);
        add(startButton);

        stopButton = new JButton("Stop");
        stopButton.setBounds(160, 70, 90, 30);
        add(stopButton);

        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                seconds++;
                timeLabel.setText("Time: " + seconds + " seconds");
            }
        });

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timer.start();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timer.stop();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleTimer();
    }
}
