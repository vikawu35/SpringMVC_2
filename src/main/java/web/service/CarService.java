package web.service;


import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.List;

@Service
public class CarService {
    public List<Car> getCars(int count, List<Car> carList) {
        if (count >= carList.size() || count <= 0) {
            return carList;
        } else {
            return carList.subList(0, count);
        }
    }
}
