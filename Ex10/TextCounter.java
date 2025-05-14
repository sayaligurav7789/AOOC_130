import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextCounter extends JFrame implements KeyListener {

    // 1. Define variables
    private JTextArea textArea;
    private JLabel countLabel;

    // 2. Constructor - Initialize GUI
    public TextCounter() {
        setTitle("Real-Time Text Counter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        countLabel = new JLabel("Characters: 0 | Words: 0");

        textArea.addKeyListener(this);

        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(countLabel, BorderLayout.SOUTH);

        setVisible(true);
    }

    // 3. Update count method
    private void updateCount() {
        String text = textArea.getText();
        int charCount = text.length();
        int wordCount = text.trim().isEmpty() ? 0 : text.trim().split("\\s+").length;

        countLabel.setText("Characters: " + charCount + " | Words: " + wordCount);
    }

    // 4. Implement KeyListener methods
    @Override
    public void keyTyped(KeyEvent e) {
        SwingUtilities.invokeLater(this::updateCount);
    }

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    // 5. Main method
    public static void main(String[] args) {
        new TextCounter();
    }
}
