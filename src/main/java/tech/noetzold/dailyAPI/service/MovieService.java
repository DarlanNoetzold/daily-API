package tech.noetzold.dailyAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.noetzold.dailyAPI.client.MovieFeignClient;
import tech.noetzold.dailyAPI.model.Movie;
import tech.noetzold.dailyAPI.model.dto.TrendingMoviesResponse;
import tech.noetzold.dailyAPI.repository.MovieRepository;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieFeignClient movieClient;

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getTrendingMovies() {
        TrendingMoviesResponse response = movieClient.getTrendingMovies("Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5MzExYzAxYWYwMmVkZTNiZTg3NDY3M2E5NGM1ZmU0ZiIsInN1YiI6IjY1ODdhN2ZjNWFiYTMyNjZiMGI5ODhiNCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.ToNV7Fr8QaoWiaD6d2fAeVbgK7v6WOL62AZtdGGZ5Mk");
        movieRepository.saveAll(response.getResults());
        return response.getResults();
    }
}