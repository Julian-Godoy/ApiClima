package com.example.ApiClima.dtos.forecast;

import lombok.Data;

@Data
public class ForecastMain {
    private double temp, feels_like, temp_min, temp_max, temp_kf;
    private short pressure, sea_level, grnd_level, humidity;
}
