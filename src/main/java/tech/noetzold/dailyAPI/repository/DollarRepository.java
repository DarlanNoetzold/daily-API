package tech.noetzold.dailyAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.noetzold.dailyAPI.model.DollarValue;

public interface DollarRepository extends JpaRepository<DollarValue, Long> {
}
