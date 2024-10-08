package com.example.ApiClima.dtos;

import lombok.Data;

@Data
public class MainDTO {
    private double temp;
    private double feels_like;
    private double temp_min;
    private double temp_max;
    private int pressure;
    private int humidity;
    private short sea_level;
    private short grnd_level;

}
