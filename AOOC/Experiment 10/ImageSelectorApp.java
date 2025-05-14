import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageSelectorApp {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Image Selector");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Image names (should match the file names in the project directory)
        String[] imageNames = {"apple.png", "banana.png", "cherry.png"};

        // Create JComboBox with image names
        JComboBox<String> imageComboBox = new JComboBox<>(imageNames);
        frame.add(imageComboBox, BorderLayout.NORTH);

        // Label to display the image
        JLabel imageLabel = new JLabel("Select an image from the dropdown", SwingConstants.CENTER);
        frame.add(imageLabel, BorderLayout.CENTER);

        // Listener to handle selection changes
        imageComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedImage = (String) imageComboBox.getSelectedItem();
                    ImageIcon icon = new ImageIcon(selectedImage); // assumes image file is in project folder
                    imageLabel.setIcon(icon);
                    imageLabel.setText(""); // remove text when image is shown
                }
            }
        });

        // Show the frame
        frame.setVisible(true);
    }
}
