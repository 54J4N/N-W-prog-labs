import java.net.*;
import java.util.*;

public class MacAddressFromIP {
    public static void main(String[] args) {
        try {
            // Replace with the desired IP address
            String ipAddress = "192.168.0.1"; // Example IP address

            InetAddress inetAddress = InetAddress.getByName(ipAddress);

            // Get NetworkInterface for the given IP address
            NetworkInterface networkInterface = NetworkInterface.getByInetAddress(inetAddress);

            if (networkInterface != null) {
                byte[] mac = networkInterface.getHardwareAddress();

                if (mac != null) {
                    // Format and display the MAC address
                    StringBuilder macAddress = new StringBuilder();
                    for (int i = 0; i < mac.length; i++) {
                        macAddress.append(String.format("%02X", mac[i]));
                        if (i != mac.length - 1) {
                            macAddress.append(":");
                        }
                    }
                    System.out.println("MAC Address for IP " + ipAddress + ": " + macAddress.toString());
                } else {
                    System.out.println("MAC address not found.");
                }
            } else {
                System.out.println("No network interface found for the given IP address.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}