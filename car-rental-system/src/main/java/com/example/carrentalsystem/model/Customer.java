package com.example.carrentalsystem.model;
import com.example.carrentalsystem.model.Customer;
//
//public class Customer {
//    private Long id;
//    private String name;
//
//    // Constructors
//    public Customer() {
//        // Default constructor
//    }
//
//    public Customer(Long id, String name) {
//        this.id = id;
//        this.name = name;
//    }
//
//    // Getters and Setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    // Optional: Override toString() for better logging/debugging
//    @Override
//    public String toString() {
//        return "Customer{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                '}';
//    }
//}
public class Customer {
    private Long id;
    private String name;
    private String email;
    private String phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
