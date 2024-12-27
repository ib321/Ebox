package com.ib.webscrap;

import java.io.IOException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Jsoup_working {
  public static void main(String[] args) throws IOException {
    String url = "https://futuretools.link/fineshare";
    Document doc = org.jsoup.Jsoup.connect(url).get();
    Element meta = doc.select("meta[http-equiv=refresh]").first();
    String content = meta.attr("content");
    String finalUrl = content.substring(content.indexOf("=") + 1);
    System.out.println("Final URL after redirection: " + finalUrl);
    
  }
}