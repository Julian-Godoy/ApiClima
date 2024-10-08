package com.example.ApiClima.dtos;

import lombok.Data;

import java.util.Map;
@Data
public class GeolocationDTO {

    private String name, country, state;

    private Map<String, String> local_names;

    private double lat, lon;

    //private CoordDTO coord;

}
