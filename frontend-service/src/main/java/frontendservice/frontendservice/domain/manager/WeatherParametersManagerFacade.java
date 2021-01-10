package com.app.frontendservice.domain.manager;

import com.app.frontendservice.domain.model.weather.WeatherParameters;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherParametersManagerFacade {

    private final WeatherParametersManager weatherParametersManager;

    public WeatherParameters getParameters() {
        return weatherParametersManager.getWeatherParameters();
    }

}
