import java.sql.*;

public class DisplayStudent {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String user = "root";
        String password = ""; // update if needed

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   ", Name: " + rs.getString("name") +
                                   ", Age: " + rs.getInt("age") +
                                   ", Course: " + rs.getString("course"));
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
