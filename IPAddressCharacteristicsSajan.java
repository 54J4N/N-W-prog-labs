import java.net.*;

public class IPAddressCharacteristicsSajan {
    public static void main(String[] args) {
        try {

            InetAddress ip = InetAddress.getLocalHost();

            System.out.println("IP Address: " + ip.getHostAddress());

            if (ip instanceof Inet4Address) {
                System.out.println("This is an IPv4 address.");
            } else if (ip instanceof Inet6Address) {
                System.out.println("This is an IPv6 address.");
            }

            if (ip.isLoopbackAddress()) {
                System.out.println("This is a Loopback address.");
            }

            if (ip.isMulticastAddress()) {
                System.out.println("This is a Multicast address.");
            }
        } catch (UnknownHostException e) {
            System.out.println("Error: Unable to resolve the host.");
        }
    }
}
