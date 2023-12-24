package tech.noetzold.dailyAPI.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import tech.noetzold.dailyAPI.model.dto.TrendingMoviesResponse;

@FeignClient( value = "movie", url = "https://api.themoviedb.org/3")
public interface MovieFeignClient {
    @GetMapping("/trending/movie/day")
    TrendingMoviesResponse getTrendingMovies(@RequestHeader("Authorization") String bearerToken);
}