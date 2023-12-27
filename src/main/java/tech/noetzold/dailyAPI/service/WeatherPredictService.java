package tech.noetzold.dailyAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.noetzold.dailyAPI.client.WeatherFeignClient;
import tech.noetzold.dailyAPI.model.dto.WeatherResponse;

@Service
public class WeatherPredictService {
    @Autowired
    private WeatherFeignClient weatherFeignClient;

    public WeatherResponse getWeather(String lat, String lon, String apiKey) {
        return weatherFeignClient.getWeather(lat, lon, apiKey);
    }
}
