import java.net.*;

public class IPAddressSajan {
    public static void main(String[] args) {
        try {
            InetAddress sajanIP = InetAddress.getLocalHost();
            System.out.println("Hello Sajan! Your system IP Address is: " + sajanIP.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("Sorry Sajan, couldn't fetch the IP address.");
            e.printStackTrace();
        }
    }
}
