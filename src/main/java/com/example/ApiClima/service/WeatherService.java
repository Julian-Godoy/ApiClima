package com.example.ApiClima.service;

import com.example.ApiClima.dtos.ForecastResponseDTO;
import com.example.ApiClima.dtos.GeolocationDTO;
import com.example.ApiClima.dtos.PollutionResponseDTO;
import com.example.ApiClima.dtos.WeatherResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class WeatherService implements WeatherServiceImplements{

    private final RestTemplate restTemplate;
    @Value("${api_key}")
    private String apiKey;



    @Autowired

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public List<GeolocationDTO> getByCityName(String city) {
        String geo_url = "http://api.openweathermap.org/geo/1.0/direct?q=" + city + "&limit=5&appid=" + apiKey;
        ResponseEntity<String> response = restTemplate.getForEntity(geo_url, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        List<GeolocationDTO> geolocationDTO = null;
        try {
            geolocationDTO = objectMapper.readValue(response.getBody(),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, GeolocationDTO.class));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return geolocationDTO;
    }

    @Override
    @Cacheable(value = "weatherCache")
    public WeatherResponseDTO getCurrentWeather(String city) {
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

    @Override
    @Cacheable(value = "forecastCache")
    public ForecastResponseDTO get5DayForecast(String city) {
        String fore_url = "https://api.openweathermap.org/data/2.5/forecast?q=" + city + "&appid=" + apiKey;
        ResponseEntity<String> response = restTemplate.getForEntity(fore_url, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        ForecastResponseDTO forecastResponseDTO = null;
        try {
            forecastResponseDTO = objectMapper.readValue(response.getBody(), ForecastResponseDTO.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return forecastResponseDTO;
    }

    @Override
    @Cacheable(value = "pollutionCache")
    public PollutionResponseDTO getAirPollution(String city, double lat, double lon) {
        String air_url = "http://api.openweathermap.org/data/2.5/air_pollution?lat=" + lat + "&lon=" + lon + "&appid=" + apiKey;
        ResponseEntity<String> response = restTemplate.getForEntity(air_url, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        PollutionResponseDTO pollutionResponseDTO = null;
        try {
            pollutionResponseDTO = objectMapper.readValue(response.getBody(), PollutionResponseDTO.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return pollutionResponseDTO;
    }

    @Override
    public void clearCacheWeather() {

    }

    @Override
    public void clearCacheForecast() {

    }

    @Override
    public void clearCacheGeolocation() {

    }

}