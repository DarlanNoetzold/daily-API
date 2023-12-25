package tech.noetzold.dailyAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.noetzold.dailyAPI.model.TVShow;
import tech.noetzold.dailyAPI.service.TVShowService;

import java.util.List;

@RestController
@RequestMapping("/tvshows")
public class TVShowController {

    @Autowired
    private TVShowService tvShowService;

    @GetMapping("/trending")
    public ResponseEntity<List<TVShow>> getTrendingTVShows() {
        List<TVShow> trendingTVShows = tvShowService.getTrendingTVShows();
        return ResponseEntity.ok(trendingTVShows);
    }
}
