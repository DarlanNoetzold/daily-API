package tech.noetzold.dailyAPI.model.dto;

import lombok.Data;
import tech.noetzold.dailyAPI.model.Game;

import java.util.List;

@Data
public class GameResponse {
    private Integer count;
    private String next;
    private String previous;
    private List<Game> results;
}
