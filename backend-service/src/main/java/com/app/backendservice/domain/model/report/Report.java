package com.app.backendservice.domain.model.report;

import lombok.*;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Report {
    private String mailAddress;
    private Double pressureAverage;
    private Double windSpeedAverage;
    private Map<String, Double> stationWithMinTemperature;
    private Map<String, Double> stationWithMaxTemperature;
}
