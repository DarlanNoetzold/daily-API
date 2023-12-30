package tech.noetzold.dailyAPI.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.noetzold.dailyAPI.model.Anime;
import tech.noetzold.dailyAPI.service.AnimeService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/animes")
public class AnimeController {

    @Autowired
    private AnimeService animeService;

    private static final Logger logger = LoggerFactory.getLogger(AnimeController.class);

    @GetMapping("/season/{year}/{season}")
    public ResponseEntity<List<Anime>> getSeasonAnimes(@PathVariable int year, @PathVariable String season) {
        List<Anime> animes = animeService.getSeasonAnimes(year, season);
        logger.info("Returning animes");
        return ResponseEntity.ok(animes);
    }
}
