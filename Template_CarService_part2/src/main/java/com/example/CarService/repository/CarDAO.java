package com.example.CarService.repository;

import com.example.CarService.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarDAO implements Dao<Car>{

    List<Car> carList = new ArrayList<>();
    @Override
    public int save(Car car) {
        return 0;
    }
}
