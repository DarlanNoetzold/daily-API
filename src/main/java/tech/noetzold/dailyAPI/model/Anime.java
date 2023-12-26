package tech.noetzold.dailyAPI.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "anime")
public class Anime {
    @Id
    @JsonProperty("mal_id")
    @Column(name = "mal_id")
    private Long malId;

    @JsonProperty("title")
    @Column(name = "title")
    private String title;

    @JsonProperty("url")
    @Column(name = "url")
    private String url;

    @JsonProperty("episodes")
    @Column(name = "episodes")
    private Integer episodes;

    @JsonProperty("rating")
    @Column(name = "rating")
    private String rating;

    @JsonProperty("score")
    @Column(name = "score")
    private Double score;

    @JsonProperty("synopsis")
    @Column(name = "synopsis", length = 5000)
    private String synopsis;

    @JsonProperty("year")
    @Column(name = "year")
    private Integer year;

    @JsonProperty("season")
    @Column(name = "season")
    private String season;
}