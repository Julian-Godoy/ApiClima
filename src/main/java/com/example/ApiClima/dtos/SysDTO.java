package com.example.ApiClima.dtos;

import lombok.Data;

@Data
public class SysDTO {
    private long type, id, sunrise,sunset;
    private String country;
}
