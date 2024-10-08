package com.example.ApiClima.dtos;

import com.example.ApiClima.dtos.forecast.*;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ForecastResponseDTO {
    private int cod, message, cnt;
    private List<forecast> list;
    private ForecastCity city;

    @Data
    public static class forecast{

        private long dt, visibility;
        private ForecastMain main;
        private ForecastWeather[] weather;
        private ForecastClouds clouds;
        private ForecastWind wind;
        private double pop;
        private Map<String, Double> rain; //Mapeo para menejar el tipo de Rian.
        private ForecastSys sys;
        private String dt_txt;
    }
}
