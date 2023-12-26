package tech.noetzold.dailyAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.noetzold.dailyAPI.client.GameFeignClient;
import tech.noetzold.dailyAPI.model.Game;
import tech.noetzold.dailyAPI.model.dto.GameResponse;
import tech.noetzold.dailyAPI.repository.GameRepository;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameFeignClient gameClient;

    @Autowired
    private GameRepository gameRepository;

    public List<Game> getGames(String dates, String platforms) {
        GameResponse response = gameClient.getGames("b54c5b97b0154fbbb34a0a822dce5510", dates, platforms);
        return gameRepository.saveAll(response.getResults());
    }
}