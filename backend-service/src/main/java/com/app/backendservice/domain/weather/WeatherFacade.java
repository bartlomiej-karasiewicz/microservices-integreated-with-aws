package com.app.backendservice.domain.weather;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class WeatherFacade {

    private final WeatherRetrievalData weatherRetrievalData;

    public Double pressureAverage() {
        return weatherRetrievalData.pressureAverage();
    }

    public Double windSpeedAverage() {
        return weatherRetrievalData.windSpeedAverage();
    }

    public Map<String, Double> stationWithMinTemperature() {
        return weatherRetrievalData.stationWithMinTemperature();
    }
    public Map<String, Double> stationWithMaxTemperature() {
        return weatherRetrievalData.stationWithMaxTemperature();
    }
    public Map<LocalDate, Double> averageTemperatureGroupingByDate() {
        return weatherRetrievalData.averageTemperatureGroupingByDate();
    }
}
