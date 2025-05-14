import java.sql.*;
import java.util.Scanner;

public class StudentCRUD {
    static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    static final String USER = "root";
    static final String PASS = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            Statement stmt = conn.createStatement();
            System.out.println("Choose operation: 1.Select 2.Insert 3.Update 4.Delete");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    ResultSet rs = stmt.executeQuery("SELECT * FROM student");
                    while (rs.next()) {
                        System.out.println("ID: " + rs.getInt("id") +
                                           ", Name: " + rs.getString("name") +
                                           ", Age: " + rs.getInt("age") +
                                           ", Course: " + rs.getString("course"));
                    }
                    break;
                case 2:
                    System.out.print("Enter name, age, course: ");
                    String name = sc.next();
                    int age = sc.nextInt();
                    String course = sc.next();
                    stmt.executeUpdate("INSERT INTO student (name, age, course) VALUES ('" + name + "', " + age + ", '" + course + "')");
                    System.out.println("Inserted.");
                    break;
                case 3:
                    System.out.print("Enter student ID to update: ");
                    int idToUpdate = sc.nextInt();
                    System.out.print("Enter new name: ");
                    String newName = sc.next();
                    stmt.executeUpdate("UPDATE student SET name='" + newName + "' WHERE id=" + idToUpdate);
                    System.out.println("Updated.");
                    break;
                case 4:
                    System.out.print("Enter student ID to delete: ");
                    int idToDelete = sc.nextInt();
                    stmt.executeUpdate("DELETE FROM student WHERE id=" + idToDelete);
                    System.out.println("Deleted.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        sc.close();
    }
}
