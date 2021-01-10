package com.app.backendservice.infrastructure.repository.weather;

import com.app.backendservice.domain.model.weather.WeatherParameters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WeatherRepository extends JpaRepository<WeatherParameters, Long> {

    @Query(value = "select avg(s.pressure) from synoptic s",
            nativeQuery = true)
    Double pressureAverage();

    @Query(value = "select avg(s.wind_speed) from synoptic s",
            nativeQuery = true)
    Double windSpeedAverage();

    @Query(value = "select * from synoptic s " +
            "where s.temperature is not null " +
            "and s.station is not null " +
            "and s.measure_date=current_date",
            nativeQuery = true)
    List<WeatherParameters> dataWithoutNulls();
}
