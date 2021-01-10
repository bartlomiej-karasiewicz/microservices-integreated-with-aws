package com.app.backendservice.infrastructure.repository.weather;

import com.app.backendservice.domain.model.weather.WeatherParameters;
import com.app.backendservice.domain.weather.WeatherRetrievalData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class WeatherRetrievalDataImpl implements WeatherRetrievalData {

    private final WeatherRepository weatherRepository;

    @Override
    public Double pressureAverage() {
        return Precision.round(weatherRepository.pressureAverage(), 2);
    }

    @Override
    public Double windSpeedAverage() {
        return Precision.round(weatherRepository.windSpeedAverage(), 2);
    }

    @Override
    public Map<String, Double> stationWithMinTemperature() {
        Double minTemperature = weatherRepository
                .dataWithoutNulls()
                .stream()
                .mapToDouble(WeatherParameters::getTemperature)
                .min()
                .getAsDouble();

        String station = weatherRepository.dataWithoutNulls()
                .stream()
                .filter(value -> minTemperature.equals(value.getTemperature()))
                .map(WeatherParameters::getStation)
                .findFirst()
                .get();
        Map<String, Double> stationWithMinTemperature = new HashMap<>();
        stationWithMinTemperature.put(station, minTemperature);
        return stationWithMinTemperature;
    }

    @Override
    public Map<String, Double> stationWithMaxTemperature() {
        Double minTemperature = weatherRepository
                .dataWithoutNulls()
                .stream()
                .mapToDouble(WeatherParameters::getTemperature)
                .max()
                .getAsDouble();
        String station = weatherRepository.dataWithoutNulls()
                .stream()
                .filter(value -> minTemperature.equals(value.getTemperature()))
                .map(WeatherParameters::getStation)
                .findFirst()
                .get();
        Map<String, Double> stationWithMaxTemperature = new HashMap<>();
        stationWithMaxTemperature.put(station, minTemperature);
        return stationWithMaxTemperature;
    }

    @Override
    public Map<LocalDate, Double> averageTemperatureGroupingByDate() {
        Map<LocalDate, Double> averageTemperatureBaseOnDate = new HashMap<>();
        weatherRepository.findAll()
                .stream()
                .collect(Collectors.groupingBy(WeatherParameters::getMeasureDate,
                        Collectors.averagingDouble(WeatherParameters::getTemperature)))
                .forEach((localDate, temperature) -> averageTemperatureBaseOnDate.put(localDate, Precision.round(temperature, 1)));
        return averageTemperatureBaseOnDate;
    }
}
