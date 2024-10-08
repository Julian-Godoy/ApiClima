package com.example.ApiClima.dtos.pollution;

import lombok.Data;

@Data
public class AirQualityDTO {
    private PollutionMain main;
    private ComponentsDTO components;
    private long dt;
}
