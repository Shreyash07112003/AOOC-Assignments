import java.io.*;
import java.net.*;

public class ChatServer {

    public static void main(String[] args) {
        int port = 12345;  // Define the port number
        try {
            // Create a server socket and bind it to the specified port
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started, waiting for clients...");

            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            // Create input and output streams for communication
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

            String message;
            // Keep listening for messages from the client
            while ((message = input.readLine()) != null) {
                System.out.println("Client: " + message);
                output.println("Server: " + message);  // Echo the message back to the client
            }

            // Close the socket and streams after communication ends
            input.close();
            output.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
