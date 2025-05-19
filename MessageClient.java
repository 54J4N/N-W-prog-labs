import java.io.*;
import java.net.*;

public class MessageClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 6000;

        try (Socket socket = new Socket(host, port);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            String line;
            System.out.println("Message from server:");
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
