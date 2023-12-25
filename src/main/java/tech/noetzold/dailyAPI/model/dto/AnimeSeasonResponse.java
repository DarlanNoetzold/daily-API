package tech.noetzold.dailyAPI.model.dto;

import lombok.Data;
import tech.noetzold.dailyAPI.model.Anime;

import java.util.List;

@Data
public class AnimeSeasonResponse {
    private List<Anime> data;
}