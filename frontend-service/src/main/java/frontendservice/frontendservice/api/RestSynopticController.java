package com.app.frontendservice.api;

import com.app.frontendservice.domain.model.weather.WeatherParameters;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class RestSynopticController {

    private final RestTemplate restTemplate;

    @GetMapping(value = "/pressure")
    public WeatherParameters getPressureAverage() {
        return restTemplate.getForObject("http://backend-service/parameters/", WeatherParameters.class);
    }
}
