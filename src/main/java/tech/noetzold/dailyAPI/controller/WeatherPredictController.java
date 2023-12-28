package tech.noetzold.dailyAPI.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.noetzold.dailyAPI.model.WeatherPredict;
import tech.noetzold.dailyAPI.service.WeatherPredictService;

@RestController
@RequestMapping("/weather")
public class WeatherPredictController {

    @Autowired
    WeatherPredictService weatherPredictService;

    @GetMapping("/now")
    public ResponseEntity<WeatherPredict> getWeather() {
        WeatherPredict weatherPredict = weatherPredictService.getWeather();
        return ResponseEntity.ok(weatherPredict);
    }
}
