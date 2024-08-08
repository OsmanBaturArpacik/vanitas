package com.teknofest.nlp.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Service
public class IgnoreWordService {
    private Set<String> ignoredWords;

    public IgnoreWordService() throws IOException {
        ignoredWords = new HashSet<>();
        loadWords("libs/ignore_word.txt");
    }

    private void loadWords(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String word;
            while ((word = br.readLine()) != null) {
                ignoredWords.add(word.trim().toLowerCase());
            }
        }
    }

    public boolean isIgnoredWord(String word) {
        return ignoredWords.contains(word.toLowerCase());
    }
}
