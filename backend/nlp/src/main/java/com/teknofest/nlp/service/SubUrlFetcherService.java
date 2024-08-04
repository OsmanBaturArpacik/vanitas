package com.teknofest.nlp.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class SubUrlFetcherService {
    public List<String> getSubURLs(String urlString, String baseUrl) {
        List<String> list = new ArrayList<>();

        try {
            Document doc = Jsoup.connect(urlString)
                    .timeout(5000) // Timeout süresi (ms)
                    .get();

            // Karakter setini belirle
            doc.outputSettings().charset(StandardCharsets.UTF_8);

            Elements links = doc.select("a[href]");

            urlConstructor(list, urlString, baseUrl, links);


        } catch (IOException e) {
            System.err.println("Error fetching URL: " + urlString + " - " + e.getMessage());
        }

        return list;
    }
    private void urlConstructor(List<String> list, String urlString, String baseUrl, Elements links) {
        String href = null;
        try {
            for (Element link : links) {
                href = link.attr("href");
                System.out.println("href:" + href);
                if (linkCondition(href, baseUrl)) {
                    URL url = new URL(new URL(urlString), href);
                    list.add(url.toString());
                } else if (href.startsWith("/") && href.length() > 1) {
                    URL url = new URL(new URL(baseUrl), href.substring(1));
                    System.out.println("url:" + url);
                    list.add(url.toString());
                } else if (href.startsWith("#") && href.length() > 1) {
                    String url = baseUrl + href;
                    System.out.println("url:" + url);
                    list.add(url.toString());
                } else if (href.contains(".html") && href.length() > 1) {
                    String url = baseUrl + '/' + href;
                    System.out.println("url:" + url);
                    list.add(url.toString());
                }

            }
        } catch (Exception e) {
            System.err.println("Error constructing URL: " + href + " - " + e.getMessage());
        }
    }

    private boolean linkCondition(String link, String baseUrl) {
        // Link null değilse ve belirtilen koşulları sağlıyorsa true döndür
        return
                link != null &&
                        (link.startsWith("http://") || link.startsWith("https://") || link.startsWith("/") || link.startsWith("#")) &&
                        link.contains(getSDL(baseUrl)) &&
                        !isSocialMediaLink(link) && // Sosyal medya bağlantılarını hariç tut
                        isValidDomainExtension(link); // Geçerli domain uzantılarını kontrol et
    }

    private boolean isSocialMediaLink(String link) {
        // Sosyal medya domainlerini kontrol et
        return link.contains("instagram") ||
                link.contains("facebook") ||
                link.contains("outlook") ||
                link.contains("twitter") ||
                link.contains("youtube") ||
                link.contains("tiktok") ||
                link.contains("linkedin");
    }
    private boolean isValidDomainExtension(String link) {
        // Geçerli domain uzantılarını kontrol et
        return
                link.endsWith(".html") ||
                        link.endsWith("/") ||
                        link.endsWith(".com") ||
                        link.endsWith(".co") ||
                        link.endsWith(".tr") ||
                        link.endsWith(".net") ||
                        link.endsWith(".org") ||
                        link.endsWith(".edu") ||
                        link.endsWith(".gov") ||
                        link.endsWith(".xyz");
    }

    private String getSDL(String link) {
        // Linki boşlukları kaldırarak başlat
        link = link.trim();

        // HTTP veya HTTPS protokollerini kontrol et ve kaldır
        if (link.startsWith("http://")) {
            link = link.substring("http://".length());
        } else if (link.startsWith("https://")) {
            link = link.substring("https://".length());
        }

        // Link içindeki ilk nokta indeksini bul
        int firstDotIndex = link.indexOf('.');
        if (firstDotIndex == -1) {
            // Nokta bulunamadıysa geçersiz SDL
            return "";
        }

        // İlk noktadan itibaren geri kalan kısmı SDL olarak al
        String sdl = link.substring(0, firstDotIndex);

        return sdl;
    }

}
