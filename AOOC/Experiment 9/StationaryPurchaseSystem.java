import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StationaryPurchaseSystem extends JFrame implements ActionListener {
    JCheckBox cbNotebook, cbPen, cbPencil;
    JButton btnOrder;

    public StationaryPurchaseSystem() {
        setTitle("Stationary Purchase System");
        setSize(350, 250);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        cbNotebook = new JCheckBox("Notebook @ 50");
        cbNotebook.setBounds(50, 30, 200, 30);

        cbPen = new JCheckBox("Pen @ 30");
        cbPen.setBounds(50, 60, 200, 30);

        cbPencil = new JCheckBox("Pencil @ 10");
        cbPencil.setBounds(50, 90, 200, 30);

        btnOrder = new JButton("Order");
        btnOrder.setBounds(100, 140, 100, 30);
        btnOrder.addActionListener(this);

        add(cbNotebook);
        add(cbPen);
        add(cbPencil);
        add(btnOrder);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        double total = 0;
        StringBuilder message = new StringBuilder();

        if (cbNotebook.isSelected()) {
            String qty = JOptionPane.showInputDialog(this, "Enter Quantity for Notebook:");
            if (qty != null && qty.matches("\\d+")) {
                int quantity = Integer.parseInt(qty);
                double cost = quantity * 50;
                total += cost;
                message.append("Notebook Quantity: ").append(quantity).append(" Total=₹").append(cost).append("\n");
            }
        }

        if (cbPen.isSelected()) {
            String qty = JOptionPane.showInputDialog(this, "Enter Quantity for Pen:");
            if (qty != null && qty.matches("\\d+")) {
                int quantity = Integer.parseInt(qty);
                double cost = quantity * 30;
                total += cost;
                message.append("Pen Quantity: ").append(quantity).append(" Total=₹").append(cost).append("\n");
            }
        }

        if (cbPencil.isSelected()) {
            String qty = JOptionPane.showInputDialog(this, "Enter Quantity for Pencil:");
            if (qty != null && qty.matches("\\d+")) {
                int quantity = Integer.parseInt(qty);
                double cost = quantity * 10;
                total += cost;
                message.append("Pencil Quantity: ").append(quantity).append(" Total=₹").append(cost).append("\n");
            }
        }

        message.append("\nTotal: ₹").append(total);
        JOptionPane.showMessageDialog(this, message.toString(), "Message", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(this, "Successfully Ordered.", "Alert", JOptionPane.WARNING_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StationaryPurchaseSystem::new);
    }
}
