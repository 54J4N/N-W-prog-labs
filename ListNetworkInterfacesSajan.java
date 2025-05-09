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
                System.out.println("Network Interface (Display Name): " + networkInterface.getDisplayName());
                System.out.println("System Name (Use in getByName): " + networkInterface.getName());

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
