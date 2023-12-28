package tech.noetzold.dailyAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class WeatherPredict implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal temp;
    private BigDecimal feels_like;
    private BigDecimal temp_min;
    private BigDecimal temp_max;
    private int pressure;
    private int humidity;
    private int sea_level;
    private int grnd_level;


    @Override
    public String toString() {
        return "Temperatura de " + temp + " sensação térmica de " + feels_like + " humidade. Temperatura mínima de " + temp_min + " e máxima de " + temp_max;
    }
}