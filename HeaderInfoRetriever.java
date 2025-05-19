import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

public class HeaderInfoRetriever {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.google.com");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Use header-specific methods
            long date = conn.getDate();
            String contentType = conn.getContentType();
            String encoding = conn.getContentEncoding();
            int contentLength = conn.getContentLength();
            long expires = conn.getExpiration();
            long lastModified = conn.getLastModified();

            System.out.println("Header Information:");
            System.out.println("Date: " + (date != 0 ? new Date(date) : "No Date Info"));
            System.out.println("Content-Type: " + (contentType != null ? contentType : "Unknown"));
            System.out.println("Content-Encoding: " + (encoding != null ? encoding : "None"));
            System.out.println("Content-Length: " + (contentLength != -1 ? contentLength + " bytes" : "Unknown"));
            System.out.println("Expires: " + (expires != 0 ? new Date(expires) : "No Expiry Info"));
            System.out.println("Last-Modified: " + (lastModified != 0 ? new Date(lastModified) : "No Info"));

            conn.disconnect();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
