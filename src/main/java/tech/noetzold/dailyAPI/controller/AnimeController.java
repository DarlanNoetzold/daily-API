package tech.noetzold.dailyAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.noetzold.dailyAPI.model.Anime;
import tech.noetzold.dailyAPI.service.AnimeService;

import java.util.List;

@RestController
@RequestMapping("/animes")
public class AnimeController {

    @Autowired
    private AnimeService animeService;

    @GetMapping("/season/{year}/{season}")
    public ResponseEntity<List<Anime>> getSeasonAnimes(@PathVariable int year, @PathVariable String season) {
        List<Anime> animes = animeService.getSeasonAnimes(year, season);
        return ResponseEntity.ok(animes);
    }
}
