import java.net.InetAddress;
import java.net.NetworkInterface;

public class DisplayIPAndMACAddress {
    public static void main(String[] args) {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            System.out.println("IP address: " + ip.getHostAddress());

            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            byte[] mac = network.getHardwareAddress();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            System.out.println("MAC address: " + sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
