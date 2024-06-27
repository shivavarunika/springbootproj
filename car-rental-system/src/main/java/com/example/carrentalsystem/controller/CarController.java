package com.example.carrentalsystem.controller;

import com.example.carrentalsystem.model.Car;
import com.example.carrentalsystem.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping
    public String getAllCars(Model model) {
        model.addAttribute("cars", carRepository.findAll());
        return "car-list";
    }

    @GetMapping("/add")
    public String showAddCarForm(Model model) {
        model.addAttribute("car", new Car());
        return "add-car";
    }

    @PostMapping("/add")
    public String addCar(Car car) {
        carRepository.save(car);
        return "redirect:/cars";
    }
}
