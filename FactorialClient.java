import java.io.*;
import java.net.*;
import java.util.Scanner;

public class FactorialClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000)) {
            Scanner scanner = new Scanner(System.in);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.print("Enter a number to calculate factorial: ");
            int num = scanner.nextInt();

            out.println(num);

            String response = in.readLine();
            System.out.println("Server Response: " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
