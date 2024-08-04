package com.teknofest.nlp.service;

import com.teknofest.nlp.api.model.SuggestionModel;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SuggestionService {
    private FetchHtmlService fetchHtmlService;
    private HtmlToTextService htmlToTextService;
    private ZemberekNormalizerService zemberekNormalizerService;

    public SuggestionService(FetchHtmlService fetchHtmlService, HtmlToTextService htmlToTextService, ZemberekNormalizerService zemberekNormalizerService) {
        this.fetchHtmlService = fetchHtmlService;
        this.htmlToTextService = htmlToTextService;
        this.zemberekNormalizerService = zemberekNormalizerService;
    }


    public JSONArray getNormalizedText(String url) {

        //TODO: check null exception
        System.out.println(url);
        String htmlContent = fetchHtmlService.getContent(url);
        if (htmlContent == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "NULL EXCEPTION");
        }
        List<String> textList  = htmlToTextService.getContent(htmlContent);
        if (htmlContent == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "NULL EXCEPTION");
        }

        List<SuggestionModel> list = zemberekNormalizerService.normalizeText(textList);
        if (htmlContent == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "NULL EXCEPTION");
        }
        JSONArray jsonArray = createJsonArray(list);

        return jsonArray;
    }

    public JSONArray createJsonArray(List<SuggestionModel> suggestionModels) {
        if (suggestionModels == null) {
            return new JSONArray();
        }
        JSONArray jsonArray = new JSONArray();
        for (SuggestionModel model : suggestionModels) {
            JSONObject jsonModel = new JSONObject();
            jsonModel.put("text", model.getText());
            jsonModel.put("suggestion", model.getSuggestion());
            jsonArray.put(jsonModel);
        }
        System.out.println("json text:" + jsonArray);
        return jsonArray;
    }

}
