package tech.noetzold.dailyAPI.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "game")
public class Game implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty("slug")
    @Column(name = "slug")
    private String slug;

    @JsonProperty("name")
    @Column(name = "name")
    private String name;

    @JsonProperty("released")
    @Column(name = "released")
    private String released;

    @JsonProperty("tba")
    @Column(name = "tba")
    private Boolean tba;

    @JsonProperty("background_image")
    @Column(name = "background_image")
    private String backgroundImage;

    @JsonProperty("rating")
    @Column(name = "rating")
    private Double rating;

    @JsonProperty("rating_top")
    @Column(name = "rating_top")
    private Integer ratingTop;

    @JsonProperty("ratings_count")
    @Column(name = "ratings_count")
    private Integer ratingsCount;
}