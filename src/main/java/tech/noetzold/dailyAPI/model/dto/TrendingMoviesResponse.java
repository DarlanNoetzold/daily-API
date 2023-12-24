package tech.noetzold.dailyAPI.model.dto;

import lombok.Data;
import tech.noetzold.dailyAPI.model.Movie;

import java.util.List;

@Data
public class TrendingMoviesResponse {
    private Integer page;
    private List<Movie> results;
    private Integer totalPages;
    private Integer totalResults;
}