import java.io.IOException;
import java.net.*;
import java.util.*;

public class ProxySelectorThatRemembersSajan {

    public static void main(String[] args) throws Exception {
        String proxyHost = "10.0.2.2"; // Change this if needed
        int proxyPort = 8080;

        // Store failed URIs
        Set<URI> failedURIs = new HashSet<>();

        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));

        ProxySelector rememberingSelector = new ProxySelector() {
            @Override
            public List<Proxy> select(URI uri) {
                if (failedURIs.contains(uri)) {
                    System.out.println("Previously failed URI: " + uri + " — Skipping proxy.");
                    return List.of(Proxy.NO_PROXY);
                }
                return List.of(proxy);
            }

            @Override
            public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
                System.out.println("Connection to " + uri + " failed: " + ioe.getMessage());
                failedURIs.add(uri);
            }
        };

        ProxySelector.setDefault(rememberingSelector);

        // Test with a URL
        URI testUri = new URI("http://example.com");
        URL url = testUri.toURL();

        System.out.println("Using proxy: " + ProxySelector.getDefault().select(testUri));

        try {
            url.openConnection().connect();
            System.out.println(" Connection Successful!");
        } catch (IOException e) {
            System.out.println(" Error connecting: " + e.getMessage());
        }

        // Try again to demonstrate memory behavior
        System.out.println("\nRetrying connection...");
        System.out.println("Using proxy: " + ProxySelector.getDefault().select(testUri));

        try {
            url.openConnection().connect();
            System.out.println(" Connection Successful on retry!");
        } catch (IOException e) {
            System.out.println(" Still failing: " + e.getMessage());
        }
    }
}
