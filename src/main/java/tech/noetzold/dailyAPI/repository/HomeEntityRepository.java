package tech.noetzold.dailyAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.noetzold.dailyAPI.model.HomeEntity;

public interface HomeEntityRepository extends JpaRepository<HomeEntity, Long> {
}
