package com.example.carrentalsystem.controller;
import com.example.carrentalsystem.model.Rental;
import com.example.carrentalsystem.Dao.RentalDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/rentals")
public class RentalController {
    @Autowired
    private RentalDao rentalDao;

    @PostMapping
    public void addRental(@RequestBody Rental rental) throws SQLException {
        rentalDao.addRental(rental);
    }

    @PutMapping("/{id}")
    public void updateRental(@PathVariable Long id, @RequestBody Rental rental) throws SQLException {
        rental.setId(id);
        rentalDao.updateRental(rental);
    }

    @DeleteMapping("/{id}")
    public void deleteRental(@PathVariable Long id) throws SQLException {
        rentalDao.deleteRental(id);
    }

    @GetMapping("/{id}")
    public Rental getRentalById(@PathVariable Long id) throws SQLException {
        return rentalDao.getRentalById(id);
    }

    @GetMapping
    public List<Rental> getAllRentals() throws SQLException {
        return rentalDao.getAllRentals();
    }
}

//
//import com.example.carrentalsystem.model.Rental;
//import com.example.carrentalsystem.model.Car;
//import com.example.carrentalsystem.model.Customer;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//@RequestMapping("/rentals")
//public class RentalController {
//
//    // Simulated data stores
//    private List<Rental> rentals = new ArrayList<>();
//    private List<Car> cars = new ArrayList<>();
//    private List<Customer> customers = new ArrayList<>();
//
//    // Constructor to initialize simulated data
//    public RentalController() {
//        // Simulate initialization of cars and customers
//        cars.add(new Car(1L, "Toyota", "Camry", 2020, "Available"));
//        cars.add(new Car(2L, "Honda", "Accord", 2019, "Available"));
//
//        customers.add(new Customer(1L, "John Doe"));
//        customers.add(new Customer(2L, "Jane Smith"));
//    }
//
//    @GetMapping
//    public String getAllRentals(Model model) {
//        // Replace with actual data retrieval logic if using JDBC or other methods
//        model.addAttribute("rentals", rentals);
//        return "rental-list";
//    }
//
//    @GetMapping("/add")
//    public String showAddRentalForm(Model model) {
//        model.addAttribute("rental", new Rental());
//        model.addAttribute("cars", cars);
//        model.addAttribute("customers", customers);
//        return "add-rental";
//    }
//
//    @PostMapping("/add")
//    public String addRental(Rental rental) {
//        // Replace with actual data storage logic if using JDBC or other methods
//        rental.setId((long) (rentals.size() + 1)); // Simulating auto-increment ID
//        rentals.add(rental); // Simulating saving to a data store
//        return "redirect:/rentals";
//    }
//}
