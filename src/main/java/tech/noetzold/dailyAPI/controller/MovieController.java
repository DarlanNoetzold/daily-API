package tech.noetzold.dailyAPI.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.noetzold.dailyAPI.model.Movie;
import tech.noetzold.dailyAPI.service.MovieService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    private static final Logger logger = LoggerFactory.getLogger(AnimeController.class);

    @GetMapping("/trending")
    public ResponseEntity<List<Movie>> getTrendingMovies() {
        List<Movie> movies = movieService.getTrendingMovies();
        logger.info("Get movies");
        return ResponseEntity.ok(movies);
    }
}
