import java.io.*;
import java.net.*;

public class ChatClient {

    public static void main(String[] args) {
        String serverAddress = "localhost";  // Server address (can be IP or "localhost")
        int port = 12345;  // The port that the server is listening on

        try {
            // Connect to the server
            Socket socket = new Socket(serverAddress, port);
            System.out.println("Connected to server!");

            // Create input and output streams
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String message;
            // Keep sending messages to the server
            while (true) {
                System.out.print("Enter message: ");
                message = userInput.readLine();
                output.println(message);  // Send message to the server
                
                // If the user types "exit", close the connection
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
                
                // Read and display the server's response
                String serverMessage = input.readLine();
                System.out.println(serverMessage);
            }

            // Close the streams and socket
            userInput.close();
            output.close();
            input.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
