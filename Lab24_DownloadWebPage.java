import java.io.*;
import java.net.*;

public class Lab24_DownloadWebPage {
    public static void main(String[] args) {
        String urlString = "https://www.example.com";
        String outputFile = "downloaded_page.html";

        try {
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            BufferedWriter out = new BufferedWriter(new FileWriter(outputFile));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                out.write(inputLine);
                out.newLine();
            }

            in.close();
            out.close();

            System.out.println("Webpage downloaded to: " + outputFile);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
