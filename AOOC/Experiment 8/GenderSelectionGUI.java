import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenderSelectionGUI {

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Gender Selection");

        // Set the frame size and close operation
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to hold the radio buttons
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Create radio buttons for male and female
        JRadioButton maleButton = new JRadioButton("Male");
        JRadioButton femaleButton = new JRadioButton("Female");

        // Group the radio buttons so that only one can be selected at a time
        ButtonGroup group = new ButtonGroup();
        group.add(maleButton);
        group.add(femaleButton);

        // Add the radio buttons to the panel
        panel.add(maleButton);
        panel.add(femaleButton);

        // Create a label to display the selected gender
        JLabel label = new JLabel("Select your gender:");

        // Add label to the panel
        panel.add(label);

        // Create a button to confirm the selection
        JButton submitButton = new JButton("Submit");

        // Action listener for the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String gender = "";
                if (maleButton.isSelected()) {
                    gender = "Male";
                } else if (femaleButton.isSelected()) {
                    gender = "Female";
                }
                JOptionPane.showMessageDialog(frame, "You selected: " + gender);
            }
        });

        // Add the submit button to the panel
        panel.add(submitButton);

        // Add the panel to the frame
        frame.add(panel);

        // Make the frame visible
        frame.setVisible(true);
    }
}
