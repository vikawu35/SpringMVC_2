package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    private List<Car> carList;
    private CarService carService;

    public CarController() {
        carList = new ArrayList<>();
        carList.add(new Car("White", 2020,"Toyota"));
        carList.add(new Car("Black", 2019, "Honda"));
        carList.add(new Car("Red", 2022,"Ford"));
        carList.add(new Car("Black", 2021, "Chevrolet"));
        carList.add(new Car("White", 2023, "BMW"));
    }

    @GetMapping("/cars")
    public String getCars(Model model) {
        List<Car> cars = carService.getCars(carList.size(), carList);
        model.addAttribute("cars", cars);
        return "cars";
    }
    @GetMapping(value = "/cars", params = "count")
    public String getCarsWithCount(Model model, @RequestParam("count") int count) {
        List<Car> cars = carService.getCars(count, carList);
        model.addAttribute("cars", cars);
        return "cars";
    }
}
