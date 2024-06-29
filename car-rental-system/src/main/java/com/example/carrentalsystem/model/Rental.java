package com.example.carrentalsystem.model;
import com.example.carrentalsystem.model.Rental;
import java.time.LocalDate;

public class Rental {
    private Long id;
    private Long carId;
    private Long customerId;
    private LocalDate rentalDate;
    private LocalDate returnDate;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

//
//import java.time.LocalDate;
//
//public class Rental {
//    private Long id;
//    private Car car;
//    private Customer customer;
//    private LocalDate rentalDate;
//    private LocalDate returnDate;
//    private String status;
//
//    // Constructors
//    public Rental() {
//    }
//
//    public Rental(Long id, Car car, Customer customer, LocalDate rentalDate, LocalDate returnDate, String status) {
//        this.id = id;
//        this.car = car;
//        this.customer = customer;
//        this.rentalDate = rentalDate;
//        this.returnDate = returnDate;
//        this.status = status;
//    }
//
//    // Getters
//    public Long getId() {
//        return id;
//    }
//
//    public Car getCar() {
//        return car;
//    }
//
//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public LocalDate getRentalDate() {
//        return rentalDate;
//    }
//
//    public LocalDate getReturnDate() {
//        return returnDate;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    // Setters
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setCar(Car car) {
//        this.car = car;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }
//
//    public void setRentalDate(LocalDate rentalDate) {
//        this.rentalDate = rentalDate;
//    }
//
//    public void setReturnDate(LocalDate returnDate) {
//        this.returnDate = returnDate;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//}
