import java.awt.*;
import java.awt.event.*;

public class SimpleGridLayout {
    public static void main(String[] args) {
        Frame frame = new Frame("GridLayout Example");

        Panel panel = new Panel();
        panel.setLayout(new GridLayout(2, 3));
        for (int i = 1; i <= 6; i++) {
            panel.add(new Button(String.valueOf(i)));
        }
        Button changeBtn = new Button("Change Layout");

        changeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.setLayout(new GridLayout(3, 2)); 
                frame.validate(); 
            }
        });
        frame.add(panel, BorderLayout.CENTER);
        frame.add(changeBtn, BorderLayout.SOUTH);
 frame.setSize(300, 200);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                frame.dispose();
            }
        });
    }
}
