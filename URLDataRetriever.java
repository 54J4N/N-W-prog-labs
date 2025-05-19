import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLDataRetriever {
    public static void main(String[] args) {
        try {

            URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");

            // Open connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set request method
            connection.setRequestMethod("GET");

            // Read the response
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line).append("\n");
            }

            reader.close();

            // Print the response
            System.out.println("Response from URL:");
            System.out.println(response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}