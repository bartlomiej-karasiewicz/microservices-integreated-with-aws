package com.app.frontendservice.infrastructure.weather;

import com.app.frontendservice.api.dto.ReceiverDto;
import com.app.frontendservice.domain.manager.WeatherParametersManager;
import com.app.frontendservice.domain.model.weather.WeatherParameters;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class WeatherParametersManagerImpl implements WeatherParametersManager {

    private final RestTemplate restTemplate;

    @Value("${second-service.address.parameters}")
    private String serviceUrl;

    @Override
    public WeatherParameters getWeatherParameters() {
        return restTemplate.getForObject(serviceUrl, WeatherParameters.class);
    }

}
