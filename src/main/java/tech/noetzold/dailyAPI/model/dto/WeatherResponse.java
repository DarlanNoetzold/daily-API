package tech.noetzold.dailyAPI.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import tech.noetzold.dailyAPI.model.WeatherPredict;
import tech.noetzold.dailyAPI.model.WeatherSky;
import tech.noetzold.dailyAPI.model.WeatherWind;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WeatherResponse implements Serializable {

    WeatherPredict main;
    WeatherSky weather;
    WeatherWind wind;
}