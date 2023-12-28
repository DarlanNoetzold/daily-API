package tech.noetzold.dailyAPI.model.dto;

import lombok.Data;
import tech.noetzold.dailyAPI.model.Anime;

import java.io.Serializable;
import java.util.List;

@Data
public class AnimeSeasonResponse implements Serializable {
    private List<Anime> data;
}