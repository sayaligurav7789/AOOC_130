import java.awt.event.*;
import javax.swing.*;

public class SimpleMouseTracker extends JFrame {
    JLabel label;

    SimpleMouseTracker() {
        setTitle("Mouse Tracker");
        setSize(300, 200);
        setLayout(null);

        label = new JLabel("Move the mouse");
        label.setBounds(50, 80, 200, 30);
        add(label);

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e) {
                label.setText("X: " + e.getX() + " Y: " + e.getY());
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleMouseTracker();
    }
}
