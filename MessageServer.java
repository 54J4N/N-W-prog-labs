import java.io.*;
import java.net.*;

public class MessageServer {
    public static void main(String[] args) {
        int port = 6000;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started. Waiting for client on port " + port + "...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String message = "Hello from Sajan!\nWe should help others and promote peace 🌍✌️";
            out.println(message);

            System.out.println("Message sent to client.");

            out.close();
            clientSocket.close();
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
