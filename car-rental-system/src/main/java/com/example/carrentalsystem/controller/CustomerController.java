package com.example.carrentalsystem.controller;

import com.example.carrentalsystem.Dao.CustomerDao;
import com.example.carrentalsystem.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerDao customerDao;

    // Create a new customer
    @PostMapping("/")
    public void createCustomer(@RequestBody Customer customer) {
        try {
            customerDao.addCustomer(customer);
        } catch (SQLException e) {
            // Handle exception appropriately (e.g., log error, return error response)
            e.printStackTrace();
        }
    }

    // Get all customers
    @GetMapping("/")
    public List<Customer> getAllCustomers() {
        try {
            return customerDao.getAllCustomers();
        } catch (SQLException e) {
            // Handle exception appropriately (e.g., log error, return error response)
            e.printStackTrace();
            return null; // or return empty list, depending on your error handling strategy
        }
    }

    // Get a customer by ID
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        try {
            return customerDao.getCustomerById(id);
        } catch (SQLException e) {
            // Handle exception appropriately (e.g., log error, return error response)
            e.printStackTrace();
            return null; // or return null, depending on your error handling strategy
        }
    }

    // Update a customer
    @PutMapping("/{id}")
    public void updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        try {
            customer.setId(id); // Set ID from path variable
            customerDao.updateCustomer(customer);
        } catch (SQLException e) {
            // Handle exception appropriately (e.g., log error, return error response)
            e.printStackTrace();
        }
    }

    // Delete a customer
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        try {
            customerDao.deleteCustomer(id);
        } catch (SQLException e) {
            // Handle exception appropriately (e.g., log error, return error response)
            e.printStackTrace();
        }
    }
}
