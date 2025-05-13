import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;

public class SupportedProtocolsChecker {
    public static void main(String[] args) {
        // Common protocols to test
        List<String> protocols = Arrays.asList("http", "https", "ftp", "file", "jar");

        for (String protocol : protocols) {
            try {
                URL url = new URL(protocol, "example.com", "");
                URLConnection connection = url.openConnection();
                connection.connect();
                System.out.println(protocol.toUpperCase() + " is supported.");
            } catch (Exception e) {
                System.out.println(protocol.toUpperCase() + " is NOT supported.");
            }
        }
    }
}
