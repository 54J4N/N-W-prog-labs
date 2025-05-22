import java.io.*;
import java.net.*;

public class FileServer {
    public static void main(String[] args) {
        int port = 5555;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("File Server started on port " + port);

            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            // File to send
            File file = new File("sajan_message.txt");
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            OutputStream os = socket.getOutputStream();

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }

            System.out.println("File sent successfully.");

            bis.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
