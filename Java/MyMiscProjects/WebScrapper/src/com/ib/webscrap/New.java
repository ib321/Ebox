package com.ib.webscrap;

import java.net.HttpURLConnection;
import java.net.URL;

public class New {
  public static void main(String[] args) throws Exception {
//    String url = "https://futuretools.link/fineshare";
//    HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
//    con.setInstanceFollowRedirects(true);
//    con.connect();
//    String realURL = con.getURL().toString();
//    System.out.println(realURL);
    
    
//    String url = "https://futuretools.link/fineshare";
//    HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
//    con.setInstanceFollowRedirects(false);
//    con.connect();
//    String location = con.getHeaderField("Location");
//    System.out.println(location);

    
    HttpURLConnection con = (HttpURLConnection) new URL("https://futuretools.link/fineshare").openConnection();
    con.setInstanceFollowRedirects(false);
    con.connect();
    int responseCode = con.getResponseCode();
    if (responseCode == HttpURLConnection.HTTP_MOVED_TEMP || responseCode == HttpURLConnection.HTTP_MOVED_PERM) {
        String location = con.getHeaderField("Location");
        System.out.println("redirectStatus Code: " + responseCode + " - Meta-Refresh Redirect");
        HttpURLConnection con1 = (HttpURLConnection) new URL(location).openConnection();
        con1.connect();
        System.out.println("Trace Complete ");
    }

  }
}
