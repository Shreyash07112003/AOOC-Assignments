import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    private final JTextField textField;
    private String input = "";
    private double result = 0;
    private String operator = "";

    public Calculator() {
        // Frame settings
        setTitle("Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Text field
        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.BOLD, 24));
        textField.setEditable(false);
        add(textField, BorderLayout.NORTH);

        // Button panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 5, 5));

        // Buttons
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C", "%", "x²", "√"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 20));
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.matches("[0-9.]")) {
            input += cmd;
            textField.setText(input);
        } else if (cmd.matches("[+\\-*/%]")) {
            operator = cmd;
            result = Double.parseDouble(input);
            input = "";
        } else if (cmd.equals("=")) {
            double secondOperand = Double.parseDouble(input);
            switch (operator) {
                case "+": result += secondOperand; break;
                case "-": result -= secondOperand; break;
                case "*": result *= secondOperand; break;
                case "/": result = secondOperand != 0 ? result / secondOperand : 0; break;
                case "%": result %= secondOperand; break;
            }
            input = String.valueOf(result);
            textField.setText(input);
        } else if (cmd.equals("C")) {
            input = "";
            operator = "";
            result = 0;
            textField.setText("");
        } else if (cmd.equals("x²")) {
            double val = Double.parseDouble(input);
            val = val * val;
            input = String.valueOf(val);
            textField.setText(input);
        } else if (cmd.equals("√")) {
            double val = Double.parseDouble(input);
            val = Math.sqrt(val);
            input = String.valueOf(val);
            textField.setText(input);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calculator::new);
    }
}
