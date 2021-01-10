package com.app.mailservice.domain.model;

import lombok.*;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Report {

    private String mailAddress;
    private Double pressureAverage;
    private Double windSpeedAverage;
    private Map<String, Double> stationWithMinTemperature;
    private Map<String, Double> stationWithMaxTemperature;

    public String reportContent() {
        return "Pressure average is: " + getPressureAverage() + "\n" +
                "Wind speed average is: " + getWindSpeedAverage() + "\n" +
                "Station with minimum temperature: " + getStationWithMinTemperature().keySet().toArray()[0] + "\n" +
                "Minimum temperature: " + getStationWithMinTemperature().values().toArray()[0] + "\n" +
                "Station with maximum temperature: " + getStationWithMaxTemperature().keySet().toArray()[0] + "\n" +
                "Maximum temperature: " + getStationWithMaxTemperature().values().toArray()[0] + "\n";
    }
}
