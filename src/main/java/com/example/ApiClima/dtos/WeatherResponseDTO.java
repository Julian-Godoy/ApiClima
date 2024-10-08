package com.example.ApiClima.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class WeatherResponseDTO {

    private Map<String, String> rain;
    private long id;
    private CoordDTO coord;
    private List<WeatherDTO> weather;
    private String base;
    private long visibility;
    private long dt;
    private long timezone;
    private int cod;
    private MainDTO main;
    private WindDTO wind;
    private CloudsDTO clouds;
    private String name;
    private SysDTO sys;
}