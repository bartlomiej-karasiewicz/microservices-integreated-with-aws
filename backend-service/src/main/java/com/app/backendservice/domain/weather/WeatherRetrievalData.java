package com.app.backendservice.domain.weather;

import java.time.LocalDate;
import java.util.Map;

public interface WeatherRetrievalData {
    Double pressureAverage();
    Double windSpeedAverage();
    Map<String, Double> stationWithMinTemperature();
    Map<String, Double> stationWithMaxTemperature();
    Map<LocalDate, Double> averageTemperatureGroupingByDate();
}
