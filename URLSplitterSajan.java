import java.net.URL;

public class URLSplitterSajan {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://example.com:8080/path/to/resource?query=123#section");

            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host: " + url.getHost());
            System.out.println("Port: " + url.getPort());
            System.out.println("Path: " + url.getPath());
            System.out.println("Query: " + url.getQuery());
            System.out.println("Ref (Fragment): " + url.getRef());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
