package tech.noetzold.dailyAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackingRepository extends JpaRepository<tech.noetzold.dailyAPI.model.TrackingResponse, Long> {
}
