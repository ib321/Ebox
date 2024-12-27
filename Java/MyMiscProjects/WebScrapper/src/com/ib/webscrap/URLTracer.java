package com.ib.webscrap;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLTracer {
    public static void main(String[] args) {
        String urlString = "https://futuretools.link/fineshare"; // Replace with the URL you want to trace

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            while (connection.getResponseCode() / 100 == 3) {
                String newUrlString = connection.getHeaderField("Location");
                URL newUrl = new URL(newUrlString);
                connection = (HttpURLConnection) newUrl.openConnection();
            }

            System.out.println("Final URL: " + connection.getURL());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

