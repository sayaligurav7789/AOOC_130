import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Stopwatch extends JFrame implements ActionListener {
    private JLabel timeLabel;
    private JButton startButton, stopButton, resetButton;
    private int hours = 0, minutes = 0, seconds = 0;
    private boolean running = false;
    private Thread stopwatchThread;

    public Stopwatch() {
        setTitle("Stopwatch");
        setSize(300, 150);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        timeLabel = new JLabel("00:00:00");
        timeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        add(timeLabel);

        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        resetButton = new JButton("Reset");

        add(startButton);
        add(stopButton);
        add(resetButton);

        startButton.addActionListener(this);
        stopButton.addActionListener(this);
        resetButton.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            if (!running) {
                running = true;
                stopwatchThread = new Thread(() -> {
                    while (running) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }

                        seconds++;
                        if (seconds == 60) {
                            seconds = 0;
                            minutes++;
                        }
                        if (minutes == 60) {
                            minutes = 0;
                            hours++;
                        }

                        SwingUtilities.invokeLater(() -> {
                            timeLabel.setText(formatTime(hours, minutes, seconds));
                        });
                    }
                });
                stopwatchThread.start();
            }
        } else if (e.getSource() == stopButton) {
            running = false;
        } else if (e.getSource() == resetButton) {
            running = false;
            hours = 0;
            minutes = 0;
            seconds = 0;
            timeLabel.setText("00:00:00");
        }
    }
    private String formatTime(int h, int m, int s) {
        return String.format("%02d:%02d:%02d", h, m, s);
    }
    public static void main(String[] args) {
        new Stopwatch();
    }
}
