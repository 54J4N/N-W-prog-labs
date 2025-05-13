import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;

public class ArbitraryHeaderRetriever {
    public static void main(String[] args) {
        try {
            // Target URL
            URL url = new URL("https://www.google.com");

            // Open connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Connect to the URL
            connection.connect();

            System.out.println("🔎 Retrieving Headers (Using Arbitrary Methods):\n");

            int i = 0;
            String headerKey;
            String headerValue;

            // Loop to fetch all headers using arbitrary access
            while ((headerKey = connection.getHeaderFieldKey(i)) != null
                    || (headerValue = connection.getHeaderField(i)) != null) {
                headerKey = connection.getHeaderFieldKey(i);
                headerValue = connection.getHeaderField(i);

                if (headerKey == null) {
                    System.out.println("Status-Line: " + headerValue);
                } else {
                    System.out.println(headerKey + ": " + headerValue);
                }
                i++;
            }

            connection.disconnect();
        } catch (IOException e) {
            System.out.println("⚠️ Error: " + e.getMessage());
        }
    }
}
