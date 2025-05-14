import java.net.URLDecoder;
import java.io.UnsupportedEncodingException;

public class URLDecoderExample {
    public static void main(String[] args) {
        try {
            // Encoded string
            String encodedString = "Hello+World%21+How+are+you%3F";

            // URL decode the string
            String decodedString = URLDecoder.decode(encodedString, "UTF-8");

            // Display the decoded string
            System.out.println("Encoded String: " + encodedString);
            System.out.println("Decoded String: " + decodedString);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
