package tech.noetzold.dailyAPI.controller;

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
    private final TVShowService tvShowService;

    public TVShowController(TVShowService tvShowService) {
        this.tvShowService = tvShowService;
    }

    @GetMapping("/trending")
    public ResponseEntity<List<TVShow>> getTrendingTVShows() {
        List<TVShow> trendingTVShows = tvShowService.getTrendingTVShows();
        return ResponseEntity.ok(trendingTVShows);
    }
}
