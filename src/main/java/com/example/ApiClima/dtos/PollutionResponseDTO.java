package com.example.ApiClima.dtos;

import ch.qos.logback.core.CoreConstants;
import com.example.ApiClima.dtos.pollution.AirQualityDTO;
import com.example.ApiClima.dtos.pollution.ComponentsDTO;
import com.example.ApiClima.dtos.pollution.PollutionCoord;
import com.example.ApiClima.dtos.pollution.PollutionMain;
import lombok.Data;

import java.util.List;

@Data
public class PollutionResponseDTO {
    private List<AirQualityDTO>list;
    private PollutionCoord coord;

}
