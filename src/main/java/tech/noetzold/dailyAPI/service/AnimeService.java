package tech.noetzold.dailyAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.noetzold.dailyAPI.client.AnimeFeignClient;
import tech.noetzold.dailyAPI.model.Anime;
import tech.noetzold.dailyAPI.model.dto.AnimeSeasonResponse;
import tech.noetzold.dailyAPI.repository.AnimeRepository;

import java.util.List;

@Service
public class AnimeService {

    @Autowired
    private AnimeFeignClient animeClient;

    @Autowired
    private AnimeRepository animeRepository;

    public List<Anime> getSeasonAnimes(int year, String season) {
        AnimeSeasonResponse response = animeClient.getSeasonAnimes(year, season);
        return animeRepository.saveAll(response.getData());
    }
}