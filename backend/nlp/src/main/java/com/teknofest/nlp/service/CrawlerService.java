package com.teknofest.nlp.service;

import org.json.JSONArray;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CrawlerService {
    private SubUrlFetcherService subUrlFetcherService;

    public CrawlerService(SubUrlFetcherService subUrlFetcherService) {
        this.subUrlFetcherService = subUrlFetcherService;
    }

    public JSONArray getUrlList(String url) {
        try {
            System.out.println(url);

            List<String> urlList = webCrawler(url);
            System.out.println(urlList);

            JSONArray jsonArray = new JSONArray(urlList);
            return jsonArray;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    public List<String> webCrawler(String baseUrl) {
//        // initial list create
//        Set<String> listOfPendingURLs = new HashSet<>();
//        Set<String> listOfTraversedURLs = new HashSet<>();
//        List<String> resultList = new ArrayList<>();
//        // initial url push into list
//        listOfPendingURLs.add(baseUrl);
//        // traverse urls
//        while (!listOfPendingURLs.isEmpty() && listOfTraversedURLs.size() <= 100) {
//            String urlString = listOfPendingURLs.iterator().next();
//            listOfPendingURLs.remove(urlString);
//
//            if (!listOfTraversedURLs.contains(urlString)) {
//                listOfTraversedURLs.add(urlString);
//                resultList.add(urlString);
//                System.out.println("Crawling:" + urlString);
//                try {
//                    List<String> subURLs = subUrlFetcherService.getSubURLs(urlString, baseUrl);
//                    for (String subURL : subURLs) {
//                        if (!listOfTraversedURLs.contains(subURL) && !listOfPendingURLs.contains(subURL)) {
//                            listOfPendingURLs.add(subURL);
//                        }
//                    }
//                } catch (Exception e) {
//                    System.err.println("Error fetching URL: " + urlString + " - " + e.getMessage());
//                }
//            }
//        }
//
//        return resultList;
//    }

//    public List<String> webCrawler(String baseUrl) {
//        // initial list create
//        List<String> listOfPendingURLs = new ArrayList<>();
//        List<String> listOfTraversedURLs = new ArrayList<>();
//        // initial url push into list
//        listOfPendingURLs.add(baseUrl);
//        // traverse urls
//        while (!listOfPendingURLs.isEmpty() && listOfTraversedURLs.size() <= 100) {
//            String urlString = listOfPendingURLs.remove(0);
//
//            if (!listOfTraversedURLs.contains(urlString)) {
//                listOfTraversedURLs.add(urlString);
//                System.out.println("Crawling:" + urlString);
//                try {
//                    List<String> subURLs = subUrlFetcherService.getSubURLs(urlString, baseUrl);
//                    for (String subURL : subURLs) {
//                        if (!listOfTraversedURLs.contains(subURL) && !listOfPendingURLs.contains(subURL)) {
//                            listOfPendingURLs.add(subURL);
//                        }
//                    }
//                } catch (Exception e) {
//                    System.err.println("Error fetching URL: " + urlString + " - " + e.getMessage());
//                }
//            }
//        }
//
//        return listOfTraversedURLs;
//    }

    public List<String> webCrawler(String baseUrl) {
        // initial list create
        List<String> listOfPendingURLs = new ArrayList<>();
        List<String> listOfTraversedURLs = new ArrayList<>();
        Set<String> alreadyCheckedSet = new HashSet<>();
        // initial url push into list
        listOfPendingURLs.add(baseUrl);
        // traverse urls
        while (!listOfPendingURLs.isEmpty() && listOfTraversedURLs.size() <= 100) {
            String urlString = listOfPendingURLs.remove(0);

            if (!listOfTraversedURLs.contains(urlString)) {
                listOfTraversedURLs.add(urlString);
                System.out.println("Crawling:" + urlString);
                try {
                    List<String> subURLs = subUrlFetcherService.getSubURLs(urlString, baseUrl);
                    for (String subURL : subURLs) {
                        if (!listOfTraversedURLs.contains(subURL) && !listOfPendingURLs.contains(subURL) && !alreadyCheckedSet.contains(subURL)) {
                            listOfPendingURLs.add(subURL);
                        }
                        alreadyCheckedSet.add(subURL);
                    }
                } catch (Exception e) {
                    System.err.println("Error fetching URL: " + urlString + " - " + e.getMessage());
                }
            }
        }

        return listOfTraversedURLs;
    }
}