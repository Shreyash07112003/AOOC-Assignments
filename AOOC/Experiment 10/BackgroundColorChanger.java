import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BackgroundColorChanger {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Background Color Changer");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Panel to change the background color
        JPanel colorPanel = new JPanel();
        frame.add(colorPanel, BorderLayout.CENTER);

        // Color options
        String[] colors = {"White", "Red", "Green", "Blue", "Yellow", "Gray"};
        JComboBox<String> colorComboBox = new JComboBox<>(colors);
        frame.add(colorComboBox, BorderLayout.NORTH);

        // Handle color selection
        colorComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedColor = (String) colorComboBox.getSelectedItem();
                    switch (selectedColor) {
                        case "Red":
                            colorPanel.setBackground(Color.RED);
                            break;
                        case "Green":
                            colorPanel.setBackground(Color.GREEN);
                            break;
                        case "Blue":
                            colorPanel.setBackground(Color.BLUE);
                            break;
                        case "Yellow":
                            colorPanel.setBackground(Color.YELLOW);
                            break;
                        case "Gray":
                            colorPanel.setBackground(Color.GRAY);
                            break;
                        default:
                            colorPanel.setBackground(Color.WHITE);
                    }
                }
            }
        });

        // Show the frame
        frame.setVisible(true);
    }
}
