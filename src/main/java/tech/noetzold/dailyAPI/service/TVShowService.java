package tech.noetzold.dailyAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tech.noetzold.dailyAPI.client.TVFeignClient;
import tech.noetzold.dailyAPI.model.TVShow;
import tech.noetzold.dailyAPI.model.dto.TrendingTVShowsResponse;
import tech.noetzold.dailyAPI.repository.TVShowRepository;

import java.util.List;

@Service
@Cacheable("tvshow")
public class TVShowService {

    @Autowired
    private TVFeignClient tvClient;

    @Autowired
    private TVShowRepository tvShowRepository;

    @Value("${spring.series.token}")
    private String token;

    public List<TVShow> getTrendingTVShows() {
        TrendingTVShowsResponse response = tvClient.getTrendingTVShows(token);
        return tvShowRepository.saveAll(response.getResults());
    }
}