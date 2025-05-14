import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class PrintHttpHeaders {
    public static void main(String[] args) {
        try {
            
            URL url = new URL("https://www.google.com");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

        
            Map<String, List<String>> headers = connection.getHeaderFields();

            System.out.println("🔍 HTTP Headers:\n");

            
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                String key = entry.getKey();
                for (String value : entry.getValue()) {
                    if (key != null) {
                        System.out.println(key + ": " + value);
                    } else {
                        
                        System.out.println(value);
                    }
                }
            }

            connection.disconnect();

        } catch (IOException e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }
}
