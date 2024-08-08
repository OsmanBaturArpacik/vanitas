package com.teknofest.nlp.api.DevTest;

import com.teknofest.nlp.service.CrawlerService;
import com.teknofest.nlp.service.SuggestionService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class DevTestController {
    private SuggestionService suggestionService;
    private CrawlerService crawlerService;

    public DevTestController(SuggestionService suggestionService, CrawlerService crawlerService) {
        this.suggestionService = suggestionService;
        this.crawlerService = crawlerService;
    }

    @PostMapping("")
    public String test(@RequestBody String url) {
        List<String> urlList = crawler(url);
        System.out.println("urlList:" + urlList );
        if (urlList == null) {
            return null;
        }
        List<String> wrongTextList = new ArrayList<>();
        List<String> temp;
        for (String urls : urlList) {
            System.out.println("urlsTEST:" + urls);
            temp = suggestion(urls);
            if (temp == null) {
                continue;
            }
            wrongTextList.addAll(temp);
        }

        String result =  convertListToString(wrongTextList);
        return result;
    }

    public String convertListToString(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String item : list) {
            sb.append(item).append("\n");
        }
        return sb.toString().trim(); // Sonuçta boş bir satır olmaması için trim() ile boşlukları temizleyebilirsiniz
    }
    public List<String> suggestion(String url) {
        if (url == null) {
            return null;
        }
        JSONArray normalizedText = suggestionService.getNormalizedText(url);
        if (normalizedText == null) {
            return null;
        }
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < normalizedText.length() ; i++) {
            JSONObject jsonObject = normalizedText.getJSONObject(i);
            String text = jsonObject.optString("text");
            if (text != null && !text.isEmpty()) {
                stringList.add(text);
            }
        }
        System.out.println("strlist" + stringList);
        return stringList;
    }

    public List<String> crawler(String url) {
        JSONArray urlList = crawlerService.getUrlList(url);
        if (urlList == null) {
            return null;
        }
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < urlList.length() ; i++) {
            stringList.add(urlList.get(i).toString());
        }
        System.out.println("test" + stringList);
        return stringList;
    }
}
