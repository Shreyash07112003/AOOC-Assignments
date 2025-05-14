import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class MouseCoordinatesDisplay {
    public static void main(String[] args) {
        // Create the main window (JFrame)
        JFrame frame = new JFrame("Mouse Coordinates Tracker");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a label to display coordinates
        JLabel label = new JLabel("Move the mouse inside the window", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 16));

        // Add MouseMotionListener to track mouse movement
        frame.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                label.setText("Mouse Coordinates: X=" + x + ", Y=" + y);
            }
        });

        // Add the label to the frame and show the window
        frame.add(label);
        frame.setVisible(true);
    }
}
