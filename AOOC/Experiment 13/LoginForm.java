username and password. Store registration data in MySQL database.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginForm extends JFrame {
    JTextField usernameField;
    JPasswordField passwordField;
    JButton registerButton;

    public LoginForm() {
        setTitle("User Registration");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Username:"));
        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        registerButton = new JButton("Register");
        add(registerButton);

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });

        setVisible(true);
    }

    private void registerUser() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        String url = "jdbc:mysql://localhost:3306/studentdb";
        String user = "root";
        String pass = "";

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Registration Successful");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new LoginForm(); } }
