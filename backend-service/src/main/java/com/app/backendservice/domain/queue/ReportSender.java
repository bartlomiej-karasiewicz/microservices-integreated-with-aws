package com.app.backendservice.domain.queue;

import com.app.backendservice.domain.model.report.Report;
import com.app.backendservice.domain.weather.WeatherRetrievalData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportSender {

    private final WeatherRetrievalData weatherRetrievalData;

    public Report sendReport(String mailAddress) {
        return Report.builder()
                .mailAddress(mailAddress)
                .pressureAverage(weatherRetrievalData.pressureAverage())
                .windSpeedAverage(weatherRetrievalData.windSpeedAverage())
                .stationWithMaxTemperature(weatherRetrievalData.stationWithMaxTemperature())
                .stationWithMinTemperature(weatherRetrievalData.stationWithMinTemperature())
                .build();
    }
}
