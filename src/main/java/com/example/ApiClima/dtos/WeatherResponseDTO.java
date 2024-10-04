package com.example.ApiClima.dtos;

import java.util.List;

public class WeatherResponseDTO{

    private CoordDTO coord;
    private List<WeatherDTO> weather;
    private MainDTO main;
    private WindDTO wind;
    private CloudsDTO clouds;
    private String name;

    public WeatherResponseDTO() {
    }

    public WeatherResponseDTO(CoordDTO coord, List<WeatherDTO> weather, MainDTO main, WindDTO wind, CloudsDTO clouds, String name) {
        this.coord = coord;
        this.weather = weather;
        this.main = main;
        this.wind = wind;
        this.clouds = clouds;
        this.name = name;
    }

    public CoordDTO getCoord() {
        return coord;
    }

    public void setCoord(CoordDTO coord) {
        this.coord = coord;
    }

    public List<WeatherDTO> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherDTO> weather) {
        this.weather = weather;
    }

    public MainDTO getMain() {
        return main;
    }

    public void setMain(MainDTO main) {
        this.main = main;
    }

    public WindDTO getWind() {
        return wind;
    }

    public void setWind(WindDTO wind) {
        this.wind = wind;
    }

    public CloudsDTO getClouds() {
        return clouds;
    }

    public void setClouds(CloudsDTO clouds) {
        this.clouds = clouds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
