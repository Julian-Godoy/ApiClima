package com.example.ApiClima.dtos;

<<<<<<< HEAD
import lombok.Data;

@Data
public class WindDTO {

    private double speed, gust;
    private int deg;

=======
public class WindDTO {

    private double speed;
    private int deg;

    public WindDTO() {
    }

    public WindDTO(double speed, int deg) {
        this.speed = speed;
        this.deg = deg;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }
>>>>>>> 9aa39af38084a47dcb7e93a23e5ac2865a5f0621
}
