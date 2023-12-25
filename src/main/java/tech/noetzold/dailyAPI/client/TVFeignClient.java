package tech.noetzold.dailyAPI.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import tech.noetzold.dailyAPI.model.dto.TrendingTVShowsResponse;

@FeignClient(name = "tvClient", url = "https://api.themoviedb.org/3")
public interface TVFeignClient {
    @GetMapping("/trending/tv/day")
    TrendingTVShowsResponse getTrendingTVShows(@RequestHeader("Authorization") String bearerToken);
}
