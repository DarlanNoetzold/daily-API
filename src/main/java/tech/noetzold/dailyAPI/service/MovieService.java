package tech.noetzold.dailyAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tech.noetzold.dailyAPI.client.MovieFeignClient;
import tech.noetzold.dailyAPI.model.Movie;
import tech.noetzold.dailyAPI.model.dto.TrendingMoviesResponse;
import tech.noetzold.dailyAPI.repository.MovieRepository;

import java.util.List;

@Service
@Cacheable("movie")
public class MovieService {
    @Autowired
    private MovieFeignClient movieClient;

    @Autowired
    private MovieRepository movieRepository;

    @Value("${spring.movie.token}")
    private String token;

    public List<Movie> getTrendingMovies() {
        TrendingMoviesResponse response = movieClient.getTrendingMovies(token);
        movieRepository.saveAll(response.getResults());
        return response.getResults();
    }
}