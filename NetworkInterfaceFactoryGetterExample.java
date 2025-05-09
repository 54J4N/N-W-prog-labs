import java.net.*;
import java.util.Enumeration;

public class NetworkInterfaceFactoryGetterExample {

    public static void main(String[] args) {
        try {
            // Retrieve all available network interfaces on the system
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

            // Print each network interface's name and associated details
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                System.out.println("Network Interface: " + networkInterface.getDisplayName());

                // Get the MAC address of the network interface
                byte[] macAddress = networkInterface.getHardwareAddress();
                if (macAddress != null) {
                    StringBuilder macAddrString = new StringBuilder();
                    for (int i = 0; i < macAddress.length; i++) {
                        macAddrString.append(String.format("%02X", macAddress[i]));
                        if (i < macAddress.length - 1) {
                            macAddrString.append(":");
                        }
                    }
                    System.out.println("  MAC Address: " + macAddrString.toString());
                }

                // Get the IP addresses of the network interface
                Enumeration<InetAddress> ipAddresses = networkInterface.getInetAddresses();
                while (ipAddresses.hasMoreElements()) {
                    InetAddress ipAddress = ipAddresses.nextElement();
                    System.out.println("  IP Address: " + ipAddress.getHostAddress());
                }

                // Print a separator between network interfaces
                System.out.println("---------------------------");
            }

            // Retrieve a specific network interface by name (example: "Wi-Fi" or "eth0")
            String interfaceName = "Wi-Fi"; // Replace with your actual interface name from previous output
            NetworkInterface specificInterface = NetworkInterface.getByName(interfaceName);
            if (specificInterface != null) {
                System.out.println("Specific Network Interface: " + specificInterface.getDisplayName());

                // Get the MAC address of the specific network interface
                byte[] macAddress = specificInterface.getHardwareAddress();
                if (macAddress != null) {
                    StringBuilder macAddrString = new StringBuilder();
                    for (int i = 0; i < macAddress.length; i++) {
                        macAddrString.append(String.format("%02X", macAddress[i]));
                        if (i < macAddress.length - 1) {
                            macAddrString.append(":");
                        }
                    }
                    System.out.println("  MAC Address: " + macAddrString.toString());
                }

                // Get the IP addresses of the specific network interface
                Enumeration<InetAddress> ipAddresses = specificInterface.getInetAddresses();
                while (ipAddresses.hasMoreElements()) {
                    InetAddress ipAddress = ipAddresses.nextElement();
                    System.out.println("  IP Address: " + ipAddress.getHostAddress());
                }
            } else {
                System.out.println("No interface found with the name: " + interfaceName);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
