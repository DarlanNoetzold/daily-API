package tech.noetzold.dailyAPI.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import tech.noetzold.dailyAPI.model.TVShow;

public interface TVShowRepository extends JpaRepository<TVShow, Long> {
}