import java.awt.*;
import java.awt.event.*;

public class FlowLayoutExample {
    public static void main(String[] args) {
        
        Frame frame = new Frame("FlowLayout Example");

        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));

        Checkbox javaCheckBox = new Checkbox("Java");
        Checkbox pythonCheckBox = new Checkbox("Python");
        Checkbox cppCheckBox = new Checkbox("C++");

        frame.add(javaCheckBox);
        frame.add(pythonCheckBox);
        frame.add(cppCheckBox);

        frame.setSize(300, 200);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
    }
}
