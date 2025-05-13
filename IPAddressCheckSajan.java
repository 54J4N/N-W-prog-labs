import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPAddressCheckSajan {
    public static void main(String[] args) {

        String[] ipAddresses = { "192.168.1.1", "2001:0db8:85a3:0000:0000:8a2e:0370:7334" };

        for (String ip : ipAddresses) {
            try {
                InetAddress inetAddress = InetAddress.getByName(ip);

                if (inetAddress instanceof java.net.Inet4Address) {
                    System.out.println(ip + " is an IPv4 address.");
                }

                else if (inetAddress instanceof java.net.Inet6Address) {
                    System.out.println(ip + " is an IPv6 address.");
                }
            } catch (UnknownHostException e) {
                System.out.println("Could not resolve the IP address: " + ip);
            }
        }
    }
}