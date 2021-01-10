package com.app.backendservice.domain.model.weather;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "synoptic")
@Builder
@Getter
@ToString
@Entity
public class WeatherParameters {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "id_station")
    private Long idStation;
    @Column(name = "station")
    private String station;
    @Column(name = "measure_date")
    private LocalDate measureDate;
    @Column(name = "measure_time")
    private Integer measureTime;
    @Column(name = "temperature")
    private Double temperature;
    @Column(name = "wind_speed")
    private Double windSpeed;
    @Column(name = "wind_direction")
    private Integer windDirection;
    @Column(name = "relative_humidity")
    private Double relativeHumidity;
    @Column(name = "total_rainfall")
    private Double totalRainfall;
    @Column(name = "pressure")
    private Double pressure;
}
