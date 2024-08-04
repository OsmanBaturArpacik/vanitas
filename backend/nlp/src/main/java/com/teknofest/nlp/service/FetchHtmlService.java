package com.teknofest.nlp.service;

import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

@Service
public class FetchHtmlService {
    public String getContent(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Optional: HTTP request headers
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                Scanner scanner = new Scanner(connection.getInputStream(), "UTF-8");
                scanner.useDelimiter("\\A");
                String htmlContent = scanner.hasNext() ? scanner.next() : "";
                scanner.close();
                System.out.println("html:" + htmlContent);
                return htmlContent;
            }
        } catch (Exception e) {
            System.out.println("Html Content Fetching Exception - " + e.getMessage());
        }
        return null;
    }

}
