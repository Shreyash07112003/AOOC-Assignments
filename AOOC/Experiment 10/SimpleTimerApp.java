import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleTimerApp {
    private static int counter = 0;
    private static Timer timer;

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Simple Timer");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Label to display the timer
        JLabel timerLabel = new JLabel("Time: 0 sec", SwingConstants.CENTER);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(timerLabel, BorderLayout.CENTER);

        // Start Button
        JButton startButton = new JButton("Start");
        // Stop Button
        JButton stopButton = new JButton("Stop");

        // Panel for buttons
        JPanel panel = new JPanel();
        panel.add(startButton);
        panel.add(stopButton);
        frame.add(panel, BorderLayout.SOUTH);

        // Timer with 1-second delay (1000 milliseconds)
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                counter++;
                timerLabel.setText("Time: " + counter + " sec");
            }
        });

        // Start button action
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!timer.isRunning()) {
                    timer.start();
                }
            }
        });

        // Stop button action
        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (timer.isRunning()) {
                    timer.stop();
                }
            }
        });

        // Show the frame
        frame.setVisible(true);
    }
}
