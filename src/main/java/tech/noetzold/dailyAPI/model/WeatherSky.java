package tech.noetzold.dailyAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.noetzold.dailyAPI.model.dto.WeatherResponse;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class WeatherSky implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String main;
    private String description;
    @ManyToOne
    @JoinColumn(name = "weather_response_id")
    private WeatherResponse weatherResponse;
}
