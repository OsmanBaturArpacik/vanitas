package com.teknofest.nlp.api.controller;

import com.teknofest.nlp.service.CrawlerService;
import org.json.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/crawler")
public class CrawlerController {
    private CrawlerService crawlerService;

    public CrawlerController(CrawlerService crawlerService) {
        this.crawlerService = crawlerService;
    }


    @PostMapping("/urls")
//    @Scope("admin")
    public ResponseEntity<String> crawler(@RequestBody String url) {
        JSONArray urlList = crawlerService.getUrlList(url);
        if (urlList != null) {
            return ResponseEntity.status(HttpStatus.OK).body(urlList.toString());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request.");
    }
}
