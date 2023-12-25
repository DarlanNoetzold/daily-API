package tech.noetzold.dailyAPI.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tv_shows")
public class TVShow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("backdrop_path")
    @Column(name = "backdrop_path")
    private String backdropPath;

    @JsonProperty("original_language")
    @Column(name = "original_language")
    private String originalLanguage;

    @JsonProperty("original_name")
    @Column(name = "original_name")
    private String originalName;

    @Column(name = "overview", length = 1000)
    private String overview;

    @JsonProperty("poster_path")
    @Column(name = "poster_path")
    private String posterPath;

    @JsonProperty("media_type")
    @Column(name = "media_type")
    private String mediaType;

    @JsonProperty("genre_id")
    @ElementCollection
    @CollectionTable(name = "tvshow_genre_ids", joinColumns = @JoinColumn(name = "tvshow_id"))
    @Column(name = "genre_id")
    private List<Integer> genreIds;

    @Column(name = "popularity")
    private Double popularity;

    @JsonProperty("first_air_date")
    @Column(name = "first_air_date")
    @Temporal(TemporalType.DATE)
    private Date firstAirDate;

    @JsonProperty("vote_average")
    @Column(name = "vote_average")
    private Double voteAverage;

    @JsonProperty("vote_count")
    @Column(name = "vote_count")
    private Integer voteCount;

    @JsonProperty("origin_country")
    @ElementCollection
    @CollectionTable(name = "tvshow_origin_country", joinColumns = @JoinColumn(name = "tvshow_id"))
    @Column(name = "origin_country")
    private List<String> originCountry;

    private String name;
}
