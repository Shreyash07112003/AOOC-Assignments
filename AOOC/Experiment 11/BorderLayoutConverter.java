import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BorderLayoutConverter {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Border Layout Example");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // NORTH: Input Panel
        JPanel northPanel = new JPanel();
        northPanel.add(new JLabel("Enter the number"));
        JTextField inputField = new JTextField(15);
        northPanel.add(inputField);
        frame.add(northPanel, BorderLayout.NORTH);

        // CENTER: Buttons Panel (Binary, Octal, Hex)
        JPanel centerPanel = new JPanel(new GridLayout(1, 3));
        JButton binaryButton = new JButton("Binary");
        JButton octalButton = new JButton("Octal");
        JButton hexButton = new JButton("Hex");
        centerPanel.add(binaryButton);
        centerPanel.add(octalButton);
        centerPanel.add(hexButton);
        frame.add(centerPanel, BorderLayout.CENTER);

        // SOUTH: Result Panel
        JPanel southPanel = new JPanel();
        southPanel.add(new JLabel("Result"));
        JTextField resultField = new JTextField(15);
        resultField.setEditable(false);
        southPanel.add(resultField);
        frame.add(southPanel, BorderLayout.SOUTH);

        // Button Actions
        binaryButton.addActionListener(e -> {
            try {
                int num = Integer.parseInt(inputField.getText());
                resultField.setText(Integer.toBinaryString(num));
            } catch (NumberFormatException ex) {
                resultField.setText("Invalid input");
            }
        });

        octalButton.addActionListener(e -> {
            try {
                int num = Integer.parseInt(inputField.getText());
                resultField.setText(Integer.toOctalString(num));
            } catch (NumberFormatException ex) {
                resultField.setText("Invalid input");
            }
        });

        hexButton.addActionListener(e -> {
            try {
                int num = Integer.parseInt(inputField.getText());
                resultField.setText(Integer.toHexString(num).toUpperCase());
            } catch (NumberFormatException ex) {
                resultField.setText("Invalid input");
            }
        });

        // Show the GUI
        frame.setVisible(true);
    }
}
