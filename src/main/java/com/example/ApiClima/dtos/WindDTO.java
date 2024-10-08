package com.example.ApiClima.dtos;

import lombok.Data;

@Data
public class WindDTO {

    private double speed, gust;
    private int deg;

}
