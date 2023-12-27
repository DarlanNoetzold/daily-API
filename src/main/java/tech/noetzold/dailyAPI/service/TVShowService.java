package tech.noetzold.dailyAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.noetzold.dailyAPI.client.TVFeignClient;
import tech.noetzold.dailyAPI.model.TVShow;
import tech.noetzold.dailyAPI.model.dto.TrendingTVShowsResponse;
import tech.noetzold.dailyAPI.repository.TVShowRepository;

import java.util.List;

@Service
public class TVShowService {
    
    @Autowired
    private TVFeignClient tvClient;

    @Autowired
    private TVShowRepository tvShowRepository;

    public List<TVShow> getTrendingTVShows() {
        TrendingTVShowsResponse response = tvClient.getTrendingTVShows("Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5MzExYzAxYWYwMmVkZTNiZTg3NDY3M2E5NGM1ZmU0ZiIsInN1YiI6IjY1ODdhN2ZjNWFiYTMyNjZiMGI5ODhiNCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.ToNV7Fr8QaoWiaD6d2fAeVbgK7v6WOL62AZtdGGZ5Mk");
        return tvShowRepository.saveAll(response.getResults());
    }
}