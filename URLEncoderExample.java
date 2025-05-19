import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class URLEncoderExample {
    public static void main(String[] args) {
        try {
            String originalString = "Hello World! & How are you Sajan?";

            String encodedString = URLEncoder.encode(originalString, "UTF-8");

            // Display the encoded string
            System.out.println("Original String: " + originalString);
            System.out.println("Encoded String: " + encodedString);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
