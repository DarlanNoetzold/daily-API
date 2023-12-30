package tech.noetzold.dailyAPI.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.noetzold.dailyAPI.model.Game;
import tech.noetzold.dailyAPI.service.GameService;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService gameService;

    private static final Logger logger = LoggerFactory.getLogger(AnimeController.class);

    @GetMapping("/trending")
    public ResponseEntity<List<Game>> getGames(@RequestParam String dates, @RequestParam String platforms) {
        List<Game> games = gameService.getGames(dates, platforms);
        logger.info("Get games");
        return ResponseEntity.ok(games);
    }
}

