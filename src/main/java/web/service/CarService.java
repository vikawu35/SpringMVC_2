package web.service;


import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private List<Car> carList = new ArrayList<>();

    public CarService() {
        carList.add(new Car("White", 2020,"Toyota"));
        carList.add(new Car("Black", 2019, "Honda"));
        carList.add(new Car("Red", 2022,"Ford"));
        carList.add(new Car("Black", 2021, "Chevrolet"));
        carList.add(new Car("White", 2023, "BMW"));
    }

    public List<Car> getAllCars() {
        return carList;
    }

    public List<Car> getCars(int count) {
        return carList.subList(0, Math.min(count, carList.size()));
    }
}
