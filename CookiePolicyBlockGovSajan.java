import java.net.*;
import java.util.*;

public class CookiePolicyBlockGovSajan {
    public static void main(String[] args) throws Exception {
        // Custom CookiePolicy that blocks .gov domains
        CookiePolicy blockGovPolicy = new CookiePolicy() {
            @Override
            public boolean shouldAccept(URI uri, HttpCookie cookie) {
                String host = uri.getHost();
                return host != null && !host.endsWith(".gov");
            }
        };

        // CookieManager with the blockGovPolicy applied
        CookieManager manager = new CookieManager(null, blockGovPolicy);
        CookieHandler.setDefault(manager);

        String[] testDomains = {
                "http://example.com",
                "http://www.nasa.gov", // .gov domain should be blocked
                "http://www.harvard.edu", // Non-.gov domain
                "http://www.usa.gov" // .gov domain should be blocked
        };

        // Add cookies for each test domain
        for (String urlString : testDomains) {
            try {
                URI uri = URI.create(urlString);
                HttpCookie cookie = new HttpCookie("Test", "Value");
                cookie.setDomain(uri.getHost());
                cookie.setPath("/");

                // Only add cookies if not from a .gov domain
                if (!uri.getHost().endsWith(".gov")) {
                    manager.getCookieStore().add(uri, cookie);
                    System.out.println("Added cookie for: " + uri.getHost());
                } else {
                    System.out.println("Blocked cookie for: " + uri.getHost());
                }
            } catch (Exception e) {
                System.out.println("Error connecting to " + urlString + ": " + e.getMessage());
            }
        }

        // Output stored cookies (should not include .gov domain cookies)
        System.out.println("\nFinal Stored Cookies:");
        for (HttpCookie cookie : manager.getCookieStore().getCookies()) {
            System.out.println("- " + cookie);
        }
    }
}
