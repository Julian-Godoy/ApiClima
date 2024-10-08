package com.example.ApiClima.dtos.forecast;

import lombok.Data;

@Data
public class ForecastCity {
    private long id, population, timezone, sunrise, sunset;
    private String name, country;
    private ForecastCoord coord;
}
