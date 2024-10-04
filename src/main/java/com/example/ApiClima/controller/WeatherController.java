package com.example.ApiClima.controller;

import com.example.ApiClima.dtos.WeatherResponseDTO;
import com.example.ApiClima.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class WeatherController {
    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }
    @GetMapping("/weather/{city}")
    public WeatherResponseDTO getCurrentWeather(@PathVariable String city) {
        return weatherService.getCurrentWeather(city);
    }
}
