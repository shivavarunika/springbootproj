package com.example.carrentalsystem.controller;

import com.example.carrentalsystem.Dao.CarDao;
import com.example.carrentalsystem.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarDao carDao;

    @Autowired
    public CarController(CarDao carDao) {
        this.carDao = carDao;
    }

    // Controller methods for handling car operations
    @PostMapping("/")
    public void createCar(@RequestBody Car car) {
        try {
            carDao.addCar(car);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception appropriately
        }
    }

    @GetMapping("/")
    public List<Car> getAllCars() {
        try {
            return carDao.getAllCars();
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // Handle error response
        }
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable Long id) {
        try {
            return carDao.getCarById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // Handle error response
        }
    }

    @PutMapping("/{id}")
    public void updateCar(@PathVariable Long id, @RequestBody Car car) {
        try {
            car.setId(id); // Set ID from path variable
            carDao.updateCar(car);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception appropriately
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        try {
            carDao.deleteCar(id);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception appropriately
        }
    }
}

//package com.example.carrentalsystem.controller;
//import com.example.carrentalsystem.Dao.CarDao;
//import com.example.carrentalsystem.model.Car;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.sql.SQLException;
//import java.util.List;
//
//@RestController
//@RequestMapping("/cars")
//public class CarController {
//    @Autowired
//    private CarDao carDao;
//
//    @PostMapping
//    public void addCar(@RequestBody Car car) throws SQLException {
//        carDao.addCar(car);
//    }
//
//    @PutMapping("/{id}")
//    public void updateCar(@PathVariable Long id, @RequestBody Car car) throws SQLException {
//        car.setId(id);
//        carDao.updateCar(car);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteCar(@PathVariable Long id) throws SQLException {
//        carDao.deleteCar(id);
//    }
//
//    @GetMapping("/{id}")
//    public Car getCarById(@PathVariable Long id) throws SQLException {
//        return carDao.getCarById(id);
//    }
//
//    @GetMapping
//    public List<Car> getAllCars() throws SQLException {
//        return carDao.getAllCars();
//    }
//}
//
