package tech.noetzold.dailyAPI.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tech.noetzold.dailyAPI.model.dto.GameResponse;

@FeignClient(name = "gameClient", url = "https://api.rawg.io/api")
public interface GameFeignClient {
    @GetMapping("/games")
    GameResponse getGames(@RequestParam String key, @RequestParam String dates, @RequestParam String platforms);
}
