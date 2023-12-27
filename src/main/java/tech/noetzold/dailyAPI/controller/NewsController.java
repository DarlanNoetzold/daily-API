package tech.noetzold.dailyAPI.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.noetzold.dailyAPI.model.dto.TabnewsResponse;
import tech.noetzold.dailyAPI.service.NewsService;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    NewsService newsService;

    @GetMapping("/trending")
    public ResponseEntity<List<TabnewsResponse>> getNews() {
        List<TabnewsResponse> news = newsService.getNews();
        return ResponseEntity.ok(news);
    }
}
