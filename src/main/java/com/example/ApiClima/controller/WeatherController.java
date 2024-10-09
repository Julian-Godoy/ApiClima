package com.example.ApiClima.controller;

import com.example.ApiClima.dtos.ForecastResponseDTO;
import com.example.ApiClima.dtos.GeolocationDTO;
import com.example.ApiClima.dtos.PollutionResponseDTO;
import com.example.ApiClima.dtos.WeatherResponseDTO;
import com.example.ApiClima.service.WeatherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RequestMapping("/api")
@RestController
public class WeatherController {
    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

@Operation(summary = "Obtiene la Geolocalización", responses = {
        @ApiResponse(responseCode = "200", description = "OK")
})
    @GetMapping("/geo/{city}")
    public ResponseEntity<List<GeolocationDTO>> getByCityName(@PathVariable String city) {
        List<GeolocationDTO> geolocationDTO = weatherService.getByCityName(city);
        return ResponseEntity.ok(geolocationDTO);
    }

    @Operation(summary = "Obtiene el clima actual", responses = {
            @ApiResponse(responseCode = "200", description = "OK")
    })
    @GetMapping("/weather/{city}")
    public ResponseEntity<WeatherResponseDTO> getCurrentWeather(@PathVariable String city) {
        WeatherResponseDTO weatherResponseDTO = weatherService.getCurrentWeather(city);
        return ResponseEntity.ok(weatherResponseDTO);
    }

    @Operation(summary = "Obtiene un pronostico de 5 dias", responses = {
            @ApiResponse(responseCode = "200", description = "OK")
    })
    @GetMapping("/forecast/{city}")
    public ResponseEntity<ForecastResponseDTO> get5DayForecast(@PathVariable String city) {
        ForecastResponseDTO forecastResponseDTO = weatherService.get5DayForecast(city);
        return ResponseEntity.ok(forecastResponseDTO);
    }

    @Operation(summary = "Obtiene los datos de polución", responses = {
            @ApiResponse(responseCode = "200", description = "OK")
    })
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

    @DeleteMapping("/delete/cacheWeather")
    public ResponseEntity<String> clearAllCacheWeather(){
        weatherService.clearCacheWeather();
        return ResponseEntity.ok("Cache for current weather has been cleared.");
    }

    @DeleteMapping("/delete/cacheForecast")
    public ResponseEntity<String> clearAllCacheForecast(){
        weatherService.clearCacheForecast();
        return ResponseEntity.ok("Cache for current forecast has been cleared.");
    }

    @DeleteMapping("/delete/cacheGeolocation")
    public ResponseEntity<String> clearAllCacheGeolocation(){
        weatherService.clearCacheGeolocation();
        return ResponseEntity.ok("Cache for current geolocation has been cleared.");
    }

}