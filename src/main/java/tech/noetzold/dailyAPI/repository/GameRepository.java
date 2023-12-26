package tech.noetzold.dailyAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.noetzold.dailyAPI.model.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
}