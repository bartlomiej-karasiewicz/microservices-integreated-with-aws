package com.app.frontendservice.domain.model.weather;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Map;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class WeatherParameters {
    private Double pressureAverage;
    private Double windSpeedAverage;
    private Map<String, Double> stationWithMinTemperature;
    private Map<String, Double> stationWithMaxTemperature;
    private Map<LocalDate, Double> averageTemperatureGroupingByDate;
}
