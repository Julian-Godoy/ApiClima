package com.example.ApiClima.controller;

import com.example.ApiClima.dtos.ForecastResponseDTO;
import com.example.ApiClima.dtos.GeolocationDTO;
import com.example.ApiClima.dtos.PollutionResponseDTO;
import com.example.ApiClima.dtos.WeatherResponseDTO;
import com.example.ApiClima.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


@RequestMapping("/api")
@RestController
public class WeatherController {
    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }


    @GetMapping("/geo/{city}")
    public ResponseEntity<List<GeolocationDTO>> getByCityName(@PathVariable String city) {
        List<GeolocationDTO> geolocationDTO = weatherService.getByCityName(city);
        return ResponseEntity.ok(geolocationDTO);
    }

    @GetMapping("/weather/{city}")
    public ResponseEntity<WeatherResponseDTO> getCurrentWeather(@PathVariable String city) {
        WeatherResponseDTO weatherResponseDTO = weatherService.getCurrentWeather(city);
        return ResponseEntity.ok(weatherResponseDTO);
    }

    @GetMapping("/forecast/{city}")
    public ResponseEntity<ForecastResponseDTO> get5DayForecast(@PathVariable String city) {
        ForecastResponseDTO forecastResponseDTO = weatherService.get5DayForecast(city);
        return ResponseEntity.ok(forecastResponseDTO);
    }

    @GetMapping("/air_pollution/{city}")
    public ResponseEntity<PollutionResponseDTO> getAirPollution(@PathVariable String city) {
        List<GeolocationDTO> geolocationList = weatherService.getByCityName(city);
        if (geolocationList == null || geolocationList.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        double lat = geolocationList.get(0).getLat();
        double lon = geolocationList.get(0).getLon();
        PollutionResponseDTO pollutionResponseDTO = weatherService.getAirPollution(city, lat, lon);
        return ResponseEntity.ok(pollutionResponseDTO);
    }


}