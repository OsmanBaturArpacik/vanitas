package com.teknofest.nlp.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Service
public class EnglishDictionaryService {
    private Set<String> englishWords;

    public EnglishDictionaryService() throws IOException {
        englishWords = new HashSet<>();
        loadWords("libs/english_words_479k.txt");
    }

    private void loadWords(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String word;
            while ((word = br.readLine()) != null) {
                englishWords.add(word.trim().toLowerCase());
            }
        }
    }

    public boolean isEnglishWord(String word) {
        return englishWords.contains(word.toLowerCase());
    }
}
