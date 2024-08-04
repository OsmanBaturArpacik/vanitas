package com.teknofest.nlp.service;

import com.teknofest.nlp.api.model.SuggestionModel;
import org.springframework.stereotype.Service;
import zemberek.morphology.TurkishMorphology;
import zemberek.normalization.TurkishSentenceNormalizer;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ZemberekNormalizerService {
    private EnglishDictionaryService englishDictionaryService;

    public ZemberekNormalizerService(EnglishDictionaryService englishDictionaryService) {
        this.englishDictionaryService = englishDictionaryService;
    }

    public List<SuggestionModel> normalizeText(List<String> texts) {
        List<SuggestionModel> suggestionListWithOriginalContent = null;
        try {
            suggestionListWithOriginalContent = zemberekNormalizer(texts.toArray(new String[0]));
            System.out.println("list normalized:" + suggestionListWithOriginalContent);
            return suggestionListWithOriginalContent;
        } catch (Exception e) {
            System.out.println("Zemberek Normalizer Exception - " + e.getMessage());
            return suggestionListWithOriginalContent;
        }
    }

    public List<SuggestionModel> zemberekNormalizer(String[] arr) throws Exception {
        java.nio.file.Path zemberekDataRoot = Paths.get("data");

        java.nio.file.Path lookupRoot = zemberekDataRoot.resolve("normalization");
        java.nio.file.Path lmPath = zemberekDataRoot.resolve("lm/lm.2gram.slm");
        TurkishMorphology morphology = TurkishMorphology.createWithDefaults();
        TurkishSentenceNormalizer normalizer = new
                TurkishSentenceNormalizer(morphology, lookupRoot, lmPath);

        List<SuggestionModel> suggestionListWithOriginalContent = new ArrayList<>();


        for (String textOriginalContent : arr) {

            String textNormalized = normalizer.normalize(textOriginalContent);

            System.out.println("Normalized text:" + textNormalized);

            if (toLowerCaseOnlyUpperCase(textOriginalContent).compareTo(textNormalized) != 0 ) {

                if (englishDictionaryService.isEnglishWord(textOriginalContent)) {

                    System.out.println("text is English:" + textOriginalContent);
                    continue;
                }

                System.out.println("text:" + textOriginalContent + " is not English.");

                suggestionListWithOriginalContent.add(new SuggestionModel(textOriginalContent, textNormalized));
            }
        }



        return suggestionListWithOriginalContent;
    }

    private String toLowerCaseOnlyUpperCase(String input) {
        HashMap<Character, Character> turkishCharacters = new HashMap<>();
        turkishCharacters.put('İ', 'i');
        turkishCharacters.put('I', 'ı');
        turkishCharacters.put('Ğ', 'ğ');
        turkishCharacters.put('Ü', 'ü');
        turkishCharacters.put('Ş', 'ş');
        turkishCharacters.put('Ö', 'ö');
        turkishCharacters.put('Ç', 'ç');

        StringBuilder result = new StringBuilder();
        System.out.println("BEFORE toLowerCaseOnlyUpperCase:" + input.toString());

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (turkishCharacters.containsKey(c)) {
                result.append(turkishCharacters.get(c));
            } else {
                result.append(Character.toLowerCase(c));
            }
        }
        System.out.println("toLowerCaseOnlyUpperCase:" + result.toString());
        return result.toString();
    }
}
