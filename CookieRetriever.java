import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class CookieRetriever {
    public static void main(String[] args) {
        try {
            // Use a site that sends cookies
            URL url = new URL("https://www.google.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Connect and retrieve headers
            connection.connect();
            Map<String, List<String>> headerFields = connection.getHeaderFields();

            List<String> cookiesHeader = headerFields.get("Set-Cookie");

            if (cookiesHeader != null) {
                System.out.println("Cookies received:");
                for (String cookie : cookiesHeader) {
                    System.out.println(cookie);
                }
            } else {
                System.out.println("No cookies received.");
            }

            connection.disconnect();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
