import java.net.NetworkInterface;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Enumeration;

public class ListNetworkInterfacesSajan {
    public static void main(String[] args) {
        try {

            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();
                System.out.println("Network Interface: " + networkInterface.getDisplayName());

                Enumeration<InetAddress> ipAddresses = networkInterface.getInetAddresses();
                while (ipAddresses.hasMoreElements()) {
                    InetAddress ip = ipAddresses.nextElement();
                    System.out.println("  IP Address: " + ip.getHostAddress());
                }
                System.out.println("---------------------------");
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}