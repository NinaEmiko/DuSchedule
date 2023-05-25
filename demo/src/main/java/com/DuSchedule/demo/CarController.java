package com.DuSchedule.demo;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String getCars(Model model) {
        try {
            Car[] cars = carService.getCars();
            model.addAttribute("cars", cars);
            System.out.println("Cars: " + Arrays.toString(cars));
            return "cars";
        } catch (Exception e) {
            model.addAttribute("error", "Failed to fetch cars");
            return "error";
        }
    }

}
