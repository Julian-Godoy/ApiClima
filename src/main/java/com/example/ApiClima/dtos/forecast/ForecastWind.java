package com.example.ApiClima.dtos.forecast;

import lombok.Data;

@Data
public class ForecastWind {
    private double speed, gust;
    private long deg;
}
