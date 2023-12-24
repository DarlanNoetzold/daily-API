package tech.noetzold.dailyAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.noetzold.dailyAPI.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}