package com.app.frontendservice.api;

import com.app.frontendservice.api.dto.ReceiverDto;
import com.app.frontendservice.domain.manager.WeatherParametersManagerFacade;
import com.app.frontendservice.domain.receiver.QueueSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;

@Controller
@Slf4j
@RequestMapping("/")
@RequiredArgsConstructor
public class WeatherController {

    private final static String INDEX_VIEW = "index";
    private final static String SUCCESS_SEND_VIEW = "success";
    private final WeatherParametersManagerFacade weatherParametersManagerFacade;
    private final QueueSender queueSender;
    private final HttpServletRequest request;

    @Value("${admin-service.address}")
    private String adminServiceAddress;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String parameters(Model model, Principal principal) {
        model.addAttribute("pressureAverage", weatherParametersManagerFacade.getParameters().getPressureAverage());
        model.addAttribute("windSpeedAverage", weatherParametersManagerFacade.getParameters().getWindSpeedAverage());
        model.addAttribute("stationWithMinTemperature", weatherParametersManagerFacade.getParameters().getStationWithMinTemperature());
        model.addAttribute("stationWithMaxTemperature", weatherParametersManagerFacade.getParameters().getStationWithMaxTemperature());
        model.addAttribute("temperatureMapGroupByDate", weatherParametersManagerFacade.getParameters().getAverageTemperatureGroupingByDate());
        model.addAttribute("receiverDto", new ReceiverDto());
        model.addAttribute("name", principal.getName());
        return INDEX_VIEW;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/email")
    public String sendMail(@Valid @ModelAttribute ReceiverDto receiverDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "redirect:/";
        }
        model.addAttribute("receiver", receiverDto);
        log.info("Message sent successfully on queue " + receiverDto);
        queueSender.sendOnQueue(receiverDto);
        return SUCCESS_SEND_VIEW;
    }

    @GetMapping(value = "/logout")
    public String logout() throws ServletException {
        request.logout();
        return "redirect:/";
    }

    @GetMapping(value = "/console")
    public String getConsole() {
        return "redirect:" + adminServiceAddress;
    }

}
