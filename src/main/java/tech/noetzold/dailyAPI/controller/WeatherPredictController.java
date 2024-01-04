package tech.noetzold.dailyAPI.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.noetzold.dailyAPI.model.dto.WeatherResponse;
import tech.noetzold.dailyAPI.service.WeatherPredictService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/weather")
public class WeatherPredictController {

    @Autowired
    WeatherPredictService weatherPredictService;

    private static final Logger logger = LoggerFactory.getLogger(AnimeController.class);

    @GetMapping("/now")
    public ResponseEntity<WeatherResponse> getWeather() {
        WeatherResponse waether = weatherPredictService.getWeather();
        logger.info("Get Weather infos");
        return ResponseEntity.ok(waether);
    }
}
