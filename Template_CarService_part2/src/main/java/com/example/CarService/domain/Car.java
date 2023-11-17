package com.example.CarService.domain;

public class Car implements Vehicle{

    private String carName;

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    @Override
    public void setVehicleType(int n) {

    }
}
