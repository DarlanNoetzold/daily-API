package tech.noetzold.dailyAPI.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tech.noetzold.dailyAPI.model.dto.AnimeSeasonResponse;

@FeignClient(name = "animeClient", url = "https://api.jikan.moe/v4")
public interface AnimeFeignClient {
    @GetMapping("/seasons/{year}/{season}")
    AnimeSeasonResponse getSeasonAnimes(@PathVariable("year") int year, @PathVariable("season") String season);
}