package tech.noetzold.dailyAPI.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import tech.noetzold.dailyAPI.model.Game;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GameResponse implements Serializable {
    private Integer count;
    private List<Game> results;
}
