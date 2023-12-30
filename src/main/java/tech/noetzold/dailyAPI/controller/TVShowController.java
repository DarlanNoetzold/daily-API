package tech.noetzold.dailyAPI.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.noetzold.dailyAPI.model.TVShow;
import tech.noetzold.dailyAPI.service.TVShowService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tvshows")
public class TVShowController {

    @Autowired
    private TVShowService tvShowService;

    private static final Logger logger = LoggerFactory.getLogger(AnimeController.class);

    @GetMapping("/trending")
    public ResponseEntity<List<TVShow>> getTrendingTVShows() {
        List<TVShow> trendingTVShows = tvShowService.getTrendingTVShows();
        logger.info("Get series");
        return ResponseEntity.ok(trendingTVShows);
    }
}
