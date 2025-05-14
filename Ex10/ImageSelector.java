import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;

public class ImageSelector extends JFrame implements ItemListener {

    private JLabel imageLabel;
    private JComboBox<String> imageComboBox;
    private String[] imageNames = {"cat.jpeg", "dog.jpeg", "bird.jpeg"};
    private final String imagePath = "D:\\AOOC-130\\Ex10\\images" + File.separator;

    public ImageSelector() {
        setTitle("Image Selector");
        setSize(500, 400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        imageComboBox = new JComboBox<>(imageNames);
        imageLabel = new JLabel("", JLabel.CENTER);

        add(imageComboBox, BorderLayout.NORTH);
        add(imageLabel, BorderLayout.CENTER);

        imageComboBox.addItemListener(this);

        displayImage(imageNames[0]);

        setVisible(true);
    }


    private void displayImage(String imageName) {
        String fullPath = imagePath + imageName;
        

        ImageIcon icon = new ImageIcon(fullPath);
        if (icon.getIconWidth() == -1) {
            imageLabel.setText("Image not found: " + imageName);
            imageLabel.setIcon(null);
        } 
        else {
            Image img = icon.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(img));
            imageLabel.setText(null);
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            String selectedImage = (String) imageComboBox.getSelectedItem();
            displayImage(selectedImage);
        }
    }

    public static void main(String[] args) {
        new ImageSelector();
    }
}
