package com.app.backendservice.api;

import com.app.backendservice.api.dto.Parameters;
import com.app.backendservice.api.dto.ReceiverDto;
import com.app.backendservice.domain.queue.QueueMessage;
import com.app.backendservice.domain.queue.ReportSender;
import com.app.backendservice.domain.weather.WeatherFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class WeatherController {

    private final WeatherFacade weatherFacade;
    private final QueueMessage queueMessage;
    private final ReportSender reportSender;

    @GetMapping(value = "/parameters", produces = MediaType.APPLICATION_JSON_VALUE)
    public Parameters parameters() {
        return Parameters.builder()
                .pressureAverage(weatherFacade.pressureAverage())
                .windSpeedAverage(weatherFacade.windSpeedAverage())
                .stationWithMinTemperature(weatherFacade.stationWithMinTemperature())
                .stationWithMaxTemperature(weatherFacade.stationWithMaxTemperature())
                .averageTemperatureGroupingByDate(weatherFacade.averageTemperatureGroupingByDate())
                .build();
    }

    @PostMapping(value = "/queue/", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void sendOnQueue(@RequestBody ReceiverDto receiverDto) {
        queueMessage.sendReportOnQueue(reportSender.sendReport(receiverDto.getMailAddress()));
        log.info("RECEIVER mail " + receiverDto.getMailAddress());
    }

}
