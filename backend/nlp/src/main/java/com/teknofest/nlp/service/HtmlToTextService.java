package com.teknofest.nlp.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HtmlToTextService {
    public List<String> getContent(String htmlContent) {
        Document document = Jsoup.parse(htmlContent, "", org.jsoup.parser.Parser.xmlParser());
        document.outputSettings().charset(StandardCharsets.UTF_8);
        // <style> ve <script> etiketlerini kaldır
        document.select("style, script").remove();
        // Remove all attributes from <a> tags
        Elements aTags = document.select("a");
        for (Element aTag : aTags) {
            aTag.text(aTag.text() + " "); // Keep only the text, remove href attribute
            aTag.removeAttr("href");
        }
        // Remove <img> tags
        document.select("img").remove();

        if (document.text().isEmpty()) {
            return null;
        }
        System.out.println("text:" + document.text());

        List<String> clearedTextList = cleanAndSplitText(document.text());
        if (clearedTextList == null) {
            return null;
        }

        System.out.println("cleared text:" + clearedTextList);

        return clearedTextList;
    }

    private List<String> cleanAndSplitText(String htmlString) {
        String cleanedText = htmlString.replaceAll("\\s+", " ").trim();
        return Arrays.stream(cleanedText.split("\\s+"))
                .map(word -> word.replaceAll("[.,!?;:*]", ""))
                .filter(word -> word.matches("[a-zA-ZığüşöçİĞÜŞÖÇ]+"))
                .collect(Collectors.toList());
    }

}
