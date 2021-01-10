package com.app.backendservice.api.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Map;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Parameters {

    private Double pressureAverage;
    private Double windSpeedAverage;
    private Map<String, Double> stationWithMinTemperature;
    private Map<String, Double> stationWithMaxTemperature;
    private Map<LocalDate, Double> averageTemperatureGroupingByDate;
}
