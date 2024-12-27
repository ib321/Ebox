package com.ib.webscrap;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class New1 {
public static void main(String[] args) throws MalformedURLException, IOException {
	URL obj = new URL("https://futuretools.link/fineshare");
	HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
	conn.setInstanceFollowRedirects(false);  //you still need to handle redirect manually.
	 
	System.out.println("Request URL ... " + obj);
	 
	while (true) {
	    if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
	        String newUrl = conn.getHeaderField("Location");
	        obj = new URL(newUrl);
	        conn = (HttpURLConnection) obj.openConnection();
	        conn.setInstanceFollowRedirects(false); //you still need to handle redirect manually.
	        System.out.println("Redirect to URL : " + newUrl);
	    } else {
	        break;
	    }
	}

}
}
