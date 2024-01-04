package tech.noetzold.dailyAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.noetzold.dailyAPI.model.WeatherPredict;
import tech.noetzold.dailyAPI.model.dto.WeatherResponse;

public interface WeatherPredictRepository extends JpaRepository<WeatherResponse, Long> {
}
