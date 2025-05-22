import java.io.*;
import java.net.*;
import java.util.Date;

public class DaytimeServer {
    public static void main(String[] args) {
        int port = 5555;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Daytime Server started on port " + port);

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    String currentTime = new Date().toString();
                    out.println("Current Server Time: " + currentTime);
                    System.out.println("Sent to client: " + currentTime);
                }
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
