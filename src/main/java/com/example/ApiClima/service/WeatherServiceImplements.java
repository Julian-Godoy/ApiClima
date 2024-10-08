package com.example.ApiClima.service;

import com.example.ApiClima.dtos.ForecastResponseDTO;
import com.example.ApiClima.dtos.GeolocationDTO;
import com.example.ApiClima.dtos.PollutionResponseDTO;
import com.example.ApiClima.dtos.WeatherResponseDTO;

import java.util.List;

public interface WeatherServiceImplements {

    List<GeolocationDTO> getByCityName(String city);

    WeatherResponseDTO getCurrentWeather(String city);

    ForecastResponseDTO get5DayForecast(String city);

    PollutionResponseDTO getAirPollution(String city, double lat, double lon);
}