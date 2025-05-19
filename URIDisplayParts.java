import java.net.URI;
import java.net.URISyntaxException;

public class URIDisplayParts {
    public static void main(String[] args) {
        try {
            // Create a URI object
            URI uri = new URI("https://www.example.com:8080/path/to/resource?query=example#fragment");

            // Display URI parts
            System.out.println("URI: " + uri);
            System.out.println("Scheme: " + uri.getScheme());
            System.out.println("Host: " + uri.getHost());
            System.out.println("Port: " + uri.getPort());
            System.out.println("Path: " + uri.getPath());
            System.out.println("Query: " + uri.getQuery());
            System.out.println("Fragment: " + uri.getFragment());

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
