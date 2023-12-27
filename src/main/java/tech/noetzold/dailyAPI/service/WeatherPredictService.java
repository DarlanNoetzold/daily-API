package tech.noetzold.dailyAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tech.noetzold.dailyAPI.client.WeatherFeignClient;
import tech.noetzold.dailyAPI.model.WeatherPredict;
import tech.noetzold.dailyAPI.model.dto.WeatherResponse;
import tech.noetzold.dailyAPI.repository.WeatherPredictRepository;

@Service
@Cacheable("weather")
public class WeatherPredictService {
    @Autowired
    private WeatherFeignClient weatherFeignClient;

    @Autowired
    private WeatherPredictRepository weatherPredictRepository;

    public WeatherPredict getWeather() {
        String lat = "-28.2612";
        String lon = "-52.4083";
        String apiKey = "1472b7ec49efc4bf9eabbdb1026f3cea";
        WeatherResponse weatherResponse = weatherFeignClient.getWeather(lat, lon, apiKey);
        WeatherResponse weatherResponseKelvin = convertKelvin(weatherResponse);
        return weatherPredictRepository.save(weatherResponseKelvin.getMain());
    }

    private WeatherResponse convertKelvin(WeatherResponse weatherResponse){
        weatherResponse.getMain().setTemp(weatherResponse.getMain().getTemp().subtract(new BigDecimal("273.15")));
        weatherResponse.getMain().setTemp_max(weatherResponse.getMain().getTemp_max().subtract(new BigDecimal("273.15")));
        weatherResponse.getMain().setTemp_min(weatherResponse.getMain().getTemp_min().subtract(new BigDecimal("273.15")));
        weatherResponse.getMain().setFeels_like(weatherResponse.getMain().getFeels_like().subtract(new BigDecimal("273.15")));

        return weatherResponse;
    }
}
