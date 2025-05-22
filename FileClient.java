import java.io.*;
import java.net.*;

public class FileClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 5555;

        try (Socket socket = new Socket(host, port)) {
            System.out.println("Connected to the server.");

            InputStream is = socket.getInputStream();
            FileOutputStream fos = new FileOutputStream("received_sajan_message.txt");
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = is.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            System.out.println("File received and saved as received_sajan_message.txt");

            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
