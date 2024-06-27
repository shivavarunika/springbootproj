package com.example.carrentalsystem.controller;

import com.example.carrentalsystem.model.Customer;
import com.example.carrentalsystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public String getAllCustomers(Model model) {
        model.addAttribute("customers", customerRepository.findAll());
        return "customer-list";
    }

    @GetMapping("/add")
    public String showAddCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "add-customer";
    }

    @PostMapping("/add")
    public String addCustomer(Customer customer) {
        customerRepository.save(customer);
        return "redirect:/customers";
    }
}
