package tech.noetzold.dailyAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tech.noetzold.dailyAPI.client.AnimeFeignClient;
import tech.noetzold.dailyAPI.model.Anime;
import tech.noetzold.dailyAPI.model.dto.AnimeSeasonResponse;
import tech.noetzold.dailyAPI.repository.AnimeRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Cacheable("anime")
public class AnimeService {

    @Autowired
    private AnimeFeignClient animeClient;

    @Autowired
    private AnimeRepository animeRepository;

    public List<Anime> getSeasonAnimes(int year, String season) {
        AnimeSeasonResponse response = animeClient.getSeasonAnimes(year, season);
        response.getData().forEach(e -> e.setRequestDate(new Date()));
        animeRepository.saveAll(response.getData());

        return response.getData();
    }
}