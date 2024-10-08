package com.example.ApiClima.dtos;

import lombok.Data;

@Data
public class WeatherDTO {
    private int id;
    private String main, description, icon;

}
