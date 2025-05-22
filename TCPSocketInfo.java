import java.io.IOException;
import java.net.Socket;

public class TCPSocketInfo {
    public static void main(String[] args) {
        String host = "google.com";
        int port = 80;

        try (Socket socket = new Socket(host, port)) {
            System.out.println("Socket connected: " + socket.isConnected());
            System.out.println("Remote Address: " + socket.getInetAddress());
            System.out.println("Remote Port: " + socket.getPort());
            System.out.println("Local Address: " + socket.getLocalAddress());
            System.out.println("Local Port: " + socket.getLocalPort());
            System.out.println("Keep Alive: " + socket.getKeepAlive());
            System.out.println("Reuse Address: " + socket.getReuseAddress());
            System.out.println("Send Buffer Size: " + socket.getSendBufferSize());
            System.out.println("Receive Buffer Size: " + socket.getReceiveBufferSize());
            System.out.println("So Timeout: " + socket.getSoTimeout());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
