package com.teknofest.nlp.api.controller;

import com.teknofest.nlp.service.SuggestionService;
import org.json.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/suggestion")
public class SuggestionController {
    private SuggestionService suggestionService;

    public SuggestionController(SuggestionService suggestionService) {
        this.suggestionService = suggestionService;
    }

    @PostMapping("/normalize")
    public ResponseEntity<String> crawler(@RequestBody String url) {
        JSONArray normalizedText = suggestionService.getNormalizedText(url);
        if (normalizedText != null) {
            return ResponseEntity.status(HttpStatus.OK).body(normalizedText.toString());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request.");
    }
}
