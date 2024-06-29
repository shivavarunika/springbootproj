package com.example.carrentalsystem.Dao;

import com.example.carrentalsystem.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {
    private Connection connection;

    // Constructor with JDBC connection initialization
    public CustomerDao(Connection connection) {
        this.connection = connection;
    }

    // Method to add a new customer
    public void addCustomer(Customer customer) throws SQLException {
        String query = "INSERT INTO customer (name, email, phone) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getEmail());
            statement.setString(3, customer.getPhone());
            statement.executeUpdate();

            // Retrieve auto-generated key (id)
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                customer.setId(generatedKeys.getLong(1));
            }
        }
    }

    // Method to update an existing customer
    public void updateCustomer(Customer customer) throws SQLException {
        String query = "UPDATE customer SET name = ?, email = ?, phone = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getEmail());
            statement.setString(3, customer.getPhone());
            statement.setLong(4, customer.getId());
            statement.executeUpdate();
        }
    }

    // Method to delete a customer by id
    public void deleteCustomer(Long customerId) throws SQLException {
        String query = "DELETE FROM customer WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, customerId);
            statement.executeUpdate();
        }
    }

    // Method to retrieve a customer by id
    public Customer getCustomerById(Long customerId) throws SQLException {
        String query = "SELECT * FROM customer WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, customerId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return extractCustomerFromResultSet(resultSet);
                }
            }
        }
        return null; // Customer not found
    }

    // Method to retrieve all customers
    public List<Customer> getAllCustomers() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT * FROM customer";
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                customers.add(extractCustomerFromResultSet(resultSet));
            }
        }
        return customers;
    }

    // Helper method to extract customer data from ResultSet
    private Customer extractCustomerFromResultSet(ResultSet resultSet) throws SQLException {
        Customer customer = new Customer();
        customer.setId(resultSet.getLong("id"));
        customer.setName(resultSet.getString("name"));
        customer.setEmail(resultSet.getString("email"));
        customer.setPhone(resultSet.getString("phone"));
        return customer;
    }
}
