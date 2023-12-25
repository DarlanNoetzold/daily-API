package tech.noetzold.dailyAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.noetzold.dailyAPI.model.Anime;

public interface AnimeRepository extends JpaRepository<Anime, Long> {
}