package com.example.carrentalsystem.controller;

import com.example.carrentalsystem.model.Rental;
import com.example.carrentalsystem.repository.RentalRepository;
import com.example.carrentalsystem.repository.CarRepository;
import com.example.carrentalsystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rentals")
public class RentalController {

    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public String getAllRentals(Model model) {
        model.addAttribute("rentals", rentalRepository.findAll());
        return "rental-list";
    }

    @GetMapping("/add")
    public String showAddRentalForm(Model model) {
        model.addAttribute("rental", new Rental());
        model.addAttribute("cars", carRepository.findAll());
        model.addAttribute("customers", customerRepository.findAll());
        return "add-rental";
    }

    @PostMapping("/add")
    public String addRental(Rental rental) {
        rentalRepository.save(rental);
        return "redirect:/rentals";
    }
}
