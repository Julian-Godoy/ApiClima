package com.example.ApiClima.service;

import com.example.ApiClima.dtos.WeatherResponseDTO;

public interface WeatherServiceImplements {
    WeatherResponseDTO getWeatherByCityName(String city);
}
