package tech.noetzold.dailyAPI.model;

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

    @Column(name = "backdrop_path")
    private String backdropPath;

    @Column(name = "original_language")
    private String originalLanguage;

    @Column(name = "original_title")
    private String originalTitle;

    @Column(name = "overview", length = 1000)
    private String overview;

    @Column(name = "poster_path")
    private String posterPath;

    @Column(name = "media_type")
    private String mediaType;

    @ElementCollection
    @CollectionTable(name = "movie_genre_ids", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "genre_id")
    private List<Integer> genreIds;

    @Column(name = "popularity")
    private Double popularity;

    @Column(name = "release_date")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @Column(name = "video")
    private Boolean video;

    @Column(name = "vote_average")
    private Double voteAverage;

    @Column(name = "vote_count")
    private Integer voteCount;

    private String title;
}
