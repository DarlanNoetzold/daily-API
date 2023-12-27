package tech.noetzold.dailyAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.noetzold.dailyAPI.model.WeatherPredict;

public interface WeatherPredictRepository extends JpaRepository<WeatherPredict, Long> {
}
