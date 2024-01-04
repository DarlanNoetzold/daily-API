package tech.noetzold.dailyAPI.model.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import tech.noetzold.dailyAPI.model.WeatherPredict;
import tech.noetzold.dailyAPI.model.WeatherSky;
import tech.noetzold.dailyAPI.model.WeatherWind;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class WeatherResponse implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private WeatherPredict main;

    @OneToMany(mappedBy = "weatherResponse", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<WeatherSky> weather;
    private WeatherWind wind;
}