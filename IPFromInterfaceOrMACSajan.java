import java.net.*;

public class IPFromInterfaceOrMACSajan {
    public static void main(String[] args) {
        try {
            NetworkInterface networkInterface = NetworkInterface.getByName("Ethernet");

            if (networkInterface != null) {
                for (InterfaceAddress address : networkInterface.getInterfaceAddresses()) {
                    InetAddress inetAddr = address.getAddress();
                    if (inetAddr != null) {
                        System.out.println("IP Address: " + inetAddr.getHostAddress());
                    }
                }
            } else {
                System.out.println("Interface not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
