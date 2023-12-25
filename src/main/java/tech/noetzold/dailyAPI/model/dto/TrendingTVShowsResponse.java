package tech.noetzold.dailyAPI.model.dto;

import lombok.Data;
import tech.noetzold.dailyAPI.model.TVShow;

import java.util.List;

@Data
public class TrendingTVShowsResponse {
    private Integer page;
    private List<TVShow> results;
    private Integer totalPages;
    private Integer totalResults;
}
