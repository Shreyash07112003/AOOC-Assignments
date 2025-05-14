import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StopwatchApp extends JFrame {
    private static final int DELAY = 100; // Delay in milliseconds for stopwatch update

    private long startTime;
    private long elapsedTime;
    private boolean running;
    private StopwatchThread stopwatchThread;
    private JLabel timeDisplay;

    public StopwatchApp() {
        startTime = 0;
        elapsedTime = 0;
        running = false;

        // Set up the GUI components
        timeDisplay = new JLabel("00:00:00", SwingConstants.CENTER);
        timeDisplay.setFont(new Font("Serif", Font.PLAIN, 50));

        JButton startStopButton = new JButton("Start");
        startStopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (running) {
                    stopStopwatch();
                    startStopButton.setText("Start");
                } else {
                    startStopwatch();
                    startStopButton.setText("Stop");
                }
            }
        });

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetStopwatch();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(timeDisplay, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startStopButton);
        buttonPanel.add(resetButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
        setTitle("Stopwatch");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void startStopwatch() {
        running = true;
        startTime = System.currentTimeMillis() - elapsedTime;
        stopwatchThread = new StopwatchThread();
        stopwatchThread.start();
    }

    private void stopStopwatch() {
        running = false;
        elapsedTime = System.currentTimeMillis() - startTime;
        if (stopwatchThread != null) {
            stopwatchThread.interrupt(); // Stop the thread
        }
    }

    private void resetStopwatch() {
        running = false;
        elapsedTime = 0;
        if (stopwatchThread != null) {
            stopwatchThread.interrupt(); // Stop the thread
        }
