package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarService carService;
    
    
    @GetMapping("/cars")
    public String getCars(@RequestParam(name = "count", required = false, defaultValue = "0") int count, Model model) {
        List<Car> cars = (count <= 0 || count >= 5) ? carService.getAllCars() : carService.getCars(count);
        model.addAttribute("cars", cars);
        return "cars";
    }
}

