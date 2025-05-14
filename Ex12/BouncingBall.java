import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BouncingBall {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncing Blue Ball");
        BallPanel panel = new BallPanel();

        frame.add(panel);
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class BallPanel extends JPanel implements Runnable, MouseListener {
    private int x = 100, y = 100;     
    private int dx = 3, dy = 3;       
    private final int radius = 20;
    private boolean running = false;

    public BallPanel() {
        addMouseListener(this);
        setBackground(Color.WHITE);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillOval(x, y, radius * 2, radius * 2);
    }

    @Override
    public void run() {
        while (running) {
          
            x += dx;
            y += dy;

           
            if (x <= 0 || x + radius * 2 >= getWidth()) {
                dx = -dx;
            }

          
            if (y <= 0 || y + radius * 2 >= getHeight()) {
                dy = -dy;
            }

            repaint();

            try {
                Thread.sleep(10); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void mousePressed(MouseEvent e) {
        if (!running) {
            running = true;
            Thread t = new Thread(this);
            t.start();
        }
    }

    public void mouseClicked(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
