package com.teknofest.nlp.api.model;

import lombok.Data;

@Data
public class SuggestionModel {
    private String text;
    private String suggestion;
    public SuggestionModel(String text, String suggestion) {
        this.text = text;
        this.suggestion = suggestion;
    }

    public String getText() {
        return text;
    }

    public String getSuggestion() {
        return suggestion;
    }

    @Override
    public String toString() {
        return "Model{ text='" + text + "', suggestion='" + suggestion + "' }";
    }
}
