import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BouncingBall extends JPanel implements MouseListener, Runnable {
    private int x, y, diameter;
    private int xSpeed, ySpeed;
    private boolean isMoving;

    public BouncingBall() {
        x = 100;
        y = 100;
        diameter = 30;
        xSpeed = 5;
        ySpeed = 5;
        isMoving = false;

        addMouseListener(this);
        setPreferredSize(new Dimension(400, 400));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillOval(x, y, diameter, diameter);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (!isMoving) {
            isMoving = true;
            new Thread(this).start();
        }
    }

    @Override
    public void run() {
        while (isMoving) {
            // Update position
            x += xSpeed;
            y += ySpeed;

            // Check for boundary collision and bounce
            if (x <= 0 || x + diameter >= getWidth()) {
                xSpeed = -xSpeed;
            }
            if (y <= 0 || y + diameter >= getHeight()) {
                ySpeed = -ySpeed;
            }

            // Repaint the panel
            repaint();

            try {
                Thread.sleep(16); // Approx 60 FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncing Ball");
        BouncingBall panel = new BouncingBall();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
