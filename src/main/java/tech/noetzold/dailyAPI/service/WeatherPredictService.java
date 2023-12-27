package tech.noetzold.dailyAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.noetzold.dailyAPI.client.WeatherFeignClient;
import tech.noetzold.dailyAPI.model.WeatherPredict;
import tech.noetzold.dailyAPI.model.dto.WeatherResponse;
import tech.noetzold.dailyAPI.repository.WeatherPredictRepository;

@Service
public class WeatherPredictService {
    @Autowired
    private WeatherFeignClient weatherFeignClient;

    @Autowired
    private WeatherPredictRepository weatherPredictRepository;

    public WeatherPredict getWeather(String lat, String lon, String apiKey) {
        WeatherResponse weatherResponse = weatherFeignClient.getWeather(lat, lon, apiKey);
        return weatherPredictRepository.save(weatherResponse.getMain());
    }
}
