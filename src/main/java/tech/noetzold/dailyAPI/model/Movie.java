package tech.noetzold.dailyAPI.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "adult")
    private Boolean adult;

    @JsonProperty("backdrop_path")
    @Column(name = "backdrop_path")
    private String backdropPath;

    @Column(name = "original_language")
    private String originalLanguage;

    @JsonProperty("original_title")
    @Column(name = "original_title")
    private String originalTitle;

    @Column(name = "overview", length = 1000)
    private String overview;

    @JsonProperty("poster_path")
    @Column(name = "poster_path")
    private String posterPath;

    @JsonProperty("media_type")
    @Column(name = "media_type")
    private String mediaType;

    @ElementCollection
    @CollectionTable(name = "movie_genre_ids", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "genre_id")
    private List<Integer> genreIds;

    @Column(name = "popularity")
    private Double popularity;

    @JsonProperty("release_date")
    @Column(name = "release_date")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @Column(name = "video")
    private Boolean video;

    @JsonProperty("vote_average")
    @Column(name = "vote_average")
    private Double voteAverage;

    @JsonProperty("vote_count")
    @Column(name = "vote_count")
    private Integer voteCount;

    private String title;
}
