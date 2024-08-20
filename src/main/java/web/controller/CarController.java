package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;
import web.service.CarServiceImpl;

import java.util.List;

@Controller
public class CarController {
    private CarServiceImpl carServiceImpl;

    @Autowired
    public CarController(CarServiceImpl carServiceImpl) {
        this.carServiceImpl = carServiceImpl;
    }

    @GetMapping("/cars")
    public String getCars(@RequestParam(required = false) Integer count, Model model) {
        List<Car> cars;

        if (count == null || count >= 5) {
            cars = carServiceImpl.index();
            model.addAttribute("cars", cars);
        } else {
            cars = carServiceImpl.getCars(count);
        }
        model.addAttribute("cars", cars);
        return "cars";
    }

}