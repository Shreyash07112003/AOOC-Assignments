import java.io.*;
import java.util.Scanner;

public class StudentInfo {

    public static void main(String[] args) {
        // File path to store student data
        String filePath = "student_info.dat";  // Adjust file path if necessary

        // Accepting student information from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student's age: ");
        int age = scanner.nextInt();

        System.out.print("Enter student's weight (kg): ");
        double weight = scanner.nextDouble();

        System.out.print("Enter student's height (meters): ");
        double height = scanner.nextDouble();

        scanner.nextLine();  // Consume the newline left by nextDouble()

        System.out.print("Enter student's city: ");
        String city = scanner.nextLine();

        System.out.print("Enter student's phone number: ");
        String phoneNumber = scanner.nextLine();

        // Store the information in a file using DataOutputStream
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
            dos.writeUTF(name);      // Write name
            dos.writeInt(age);       // Write age
            dos.writeDouble(weight); // Write weight
            dos.writeDouble(height); // Write height
            dos.writeUTF(city);      // Write city
            dos.writeUTF(phoneNumber); // Write phone number
            System.out.println("Student information saved to file.");
        } catch (IOException e) {
            System.out.println("Error writing data to file: " + e.getMessage());
        }

        // Retrieve and display the information from the file using DataInputStream
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            String studentName = dis.readUTF();
            int studentAge = dis.readInt();
            double studentWeight = dis.readDouble();
            double studentHeight = dis.readDouble();
            String studentCity = dis.readUTF();
            String studentPhoneNumber = dis.readUTF();

            // Display the student information
            System.out.println("\nStudent Information:");
            System.out.println("Name: " + studentName);
            System.out.println("Age: " + studentAge);
            System.out.println("Weight: " + studentWeight + " kg");
            System.out.println("Height: " + studentHeight + " meters");
            System.out.println("City: " + studentCity);
            System.out.println("Phone Number: " + studentPhoneNumber);
        } catch (IOException e) {
            System.out.println("Error reading data from file: " + e.getMessage());
        }

        scanner.close();
    }
}
