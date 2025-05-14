import java.io.*;
import java.net.*;

public class SumServer {

    public static void main(String[] args) {
        int port = 12345;  // Port number on which server listens
        
        try {
            // Create a server socket and bind it to the specified port
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started, waiting for client...");

            // Accept a client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            // Create input and output streams for communication
            DataInputStream input = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());

            // Read two numbers from the client
            int num1 = input.readInt();
            int num2 = input.readInt();

            // Calculate the sum
            int sum = num1 + num2;

            // Send the sum back to the client
            output.writeInt(sum);
            System.out.println("Sum sent to client: " + sum);

            // Close the connections
            input.close();
            output.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
