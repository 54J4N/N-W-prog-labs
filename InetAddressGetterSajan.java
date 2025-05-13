import java.net.*;

public class InetAddressGetterSajan {
    public static void main(String[] args) {
        try {
            InetAddress sajanAddress = InetAddress.getLocalHost();

            System.out.println("Host Name: " + sajanAddress.getHostName());
            System.out.println("Canonical Host Name: " + sajanAddress.getCanonicalHostName());
            System.out.println("IP Address: " + sajanAddress.getHostAddress());

            byte[] rawAddress = sajanAddress.getAddress();
            System.out.print("Raw Address (bytes): ");
            for (byte b : rawAddress) {
                System.out.print((b & 0xFF) + " ");
            }

        } catch (UnknownHostException e) {
            System.out.println("Unable to retrieve InetAddress info for Sajan.");
            e.printStackTrace();
        }
    }
}
