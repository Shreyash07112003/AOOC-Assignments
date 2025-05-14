import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SumClient {

    public static void main(String[] args) {
        String serverAddress = "localhost";  // Server address (can be IP or "localhost")
        int port = 12345;  // The port the server is listening on

        try {
            // Connect to the server
            Socket socket = new Socket(serverAddress, port);
            System.out.println("Connected to server!");

            // Create input and output streams
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Create scanner to read input from user
            Scanner scanner = new Scanner(System.in);

            // Prompt user to input two numbers
            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();

            // Send the numbers to the server
            output.writeInt(num1);
            output.writeInt(num2);

            // Read the result from the server
            int sum = input.readInt();
            System.out.println("Sum from server: " + sum);

            // Close the scanner and streams
            scanner.close();
            input.close();
            output.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
