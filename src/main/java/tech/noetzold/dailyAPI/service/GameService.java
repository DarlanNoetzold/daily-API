package tech.noetzold.dailyAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tech.noetzold.dailyAPI.client.GameFeignClient;
import tech.noetzold.dailyAPI.model.Game;
import tech.noetzold.dailyAPI.model.dto.GameResponse;
import tech.noetzold.dailyAPI.repository.GameRepository;

import java.util.Date;
import java.util.List;

@Service
@Cacheable("game")
public class GameService {

    @Autowired
    private GameFeignClient gameClient;

    @Autowired
    private GameRepository gameRepository;

    @Value("${spring.game.token}")
    private String token;

    public List<Game> getGames(String dates, String platforms) {
        GameResponse response = gameClient.getGames(token, dates, platforms);
        response.getResults().forEach(e -> e.setRequestDate(new Date()));
        gameRepository.saveAll(response.getResults());

        return response.getResults();
    }
}