import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextCounterApp {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Text Counter");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create a JTextArea for user input
        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Label to display counts
        JLabel countLabel = new JLabel("Characters: 0 | Words: 0");
        countLabel.setFont(new Font("Arial", Font.BOLD, 14));
        frame.add(countLabel, BorderLayout.SOUTH);

        // Add KeyListener to update counts on typing
        textArea.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String text = textArea.getText();
                int charCount = text.length();
                int wordCount = text.trim().isEmpty() ? 0 : text.trim().split("\\s+").length;
                countLabel.setText("Characters: " + charCount + " | Words: " + wordCount);
            }
        });

        // Show the frame
        frame.setVisible(true);
    }
}
