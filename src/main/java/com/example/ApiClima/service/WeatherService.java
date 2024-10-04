package com.example.ApiClima.service;

import com.example.ApiClima.dtos.WeatherResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class WeatherService implements WeatherServiceImplements {

    private final RestTemplate restTemplate;
    private final String apiKey = "0dc167c180cde54dcc0e4128aafbc97a";

    @Autowired
    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public WeatherResponseDTO getWeatherByCityName(String city) {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        WeatherResponseDTO weatherResponseDTO = null;
        try {
            weatherResponseDTO = objectMapper.readValue(response.getBody(), WeatherResponseDTO.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return weatherResponseDTO;
    }

    public WeatherResponseDTO getCurrentWeather(String city) {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;
        return restTemplate.getForObject(url, WeatherResponseDTO.class);
    }
}
