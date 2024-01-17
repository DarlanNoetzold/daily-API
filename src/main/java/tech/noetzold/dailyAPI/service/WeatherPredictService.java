package tech.noetzold.dailyAPI.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tech.noetzold.dailyAPI.client.WeatherFeignClient;
import tech.noetzold.dailyAPI.model.WeatherPredict;
import tech.noetzold.dailyAPI.model.dto.WeatherResponse;
import tech.noetzold.dailyAPI.repository.WeatherPredictRepository;

import java.math.BigDecimal;
import java.util.Date;

@Service
@Cacheable("weather")
public class WeatherPredictService {
    @Autowired
    private WeatherFeignClient weatherFeignClient;

    @Autowired
    private WeatherPredictRepository weatherPredictRepository;

    @Value("${spring.weather.token}")
    private String token;

    @Transactional
    public WeatherResponse getWeather() {
        String lat = "-28.2612";
        String lon = "-52.4083";
        WeatherResponse weatherResponse = weatherFeignClient.getWeather(lat, lon, token);
        WeatherResponse weatherResponseKelvin = convertKelvin(weatherResponse);
        weatherResponseKelvin.getMain().setRequestDate(new Date());
        weatherPredictRepository.save(weatherResponseKelvin);

        return weatherResponseKelvin;
    }

    private WeatherResponse convertKelvin(WeatherResponse weatherResponse){
        weatherResponse.getMain().setTemp(weatherResponse.getMain().getTemp().subtract(new BigDecimal("273.15")));
        weatherResponse.getMain().setTemp_max(weatherResponse.getMain().getTemp_max().subtract(new BigDecimal("273.15")));
        weatherResponse.getMain().setTemp_min(weatherResponse.getMain().getTemp_min().subtract(new BigDecimal("273.15")));
        weatherResponse.getMain().setFeels_like(weatherResponse.getMain().getFeels_like().subtract(new BigDecimal("273.15")));

        return weatherResponse;
    }
}
