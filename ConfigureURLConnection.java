import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class ConfigureURLConnection {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://httpbin.org/post"); // Using httpbin for testing POST requests
            URLConnection connection = url.openConnection();

            // Configuration
            connection.setDoOutput(true); // Enable output for POST
            connection.setDoInput(true);  // Enable input
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("User-Agent", "Custom Java Client/1.0");
            connection.setConnectTimeout(5000); // 5 seconds
            connection.setReadTimeout(5000);    // 5 seconds

            // Sending POST data
            String postData = "name=Sajan&lab=23";
            try (OutputStream os = connection.getOutputStream()) {
                os.write(postData.getBytes());
                os.flush();
            }

            // Reading response
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {
                String line;
                System.out.println("Server Response:");
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                }
            }

        } catch (Exception e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }
}
