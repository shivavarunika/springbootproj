package com.example.carrentalsystem.Dao;
import com.example.carrentalsystem.model.Rental;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class RentalDao {
    private Connection connection;

    // Constructor with JDBC connection initialization
    public RentalDao(Connection connection) {
        this.connection = connection;
    }

    // Method to add a new rental
    public void addRental(Rental rental) throws SQLException {
        String query = "INSERT INTO rental (car_id, customer_id, rental_date, return_date, status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setLong(1, rental.getCarId());
            statement.setLong(2, rental.getCustomerId());
            statement.setObject(3, rental.getRentalDate());
            statement.setObject(4, rental.getReturnDate());
            statement.setString(5, rental.getStatus());
            statement.executeUpdate();

            // Retrieve auto-generated key (id)
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                rental.setId(generatedKeys.getLong(1));
            }
        }
    }

    // Method to update an existing rental
    public void updateRental(Rental rental) throws SQLException {
        String query = "UPDATE rental SET car_id = ?, customer_id = ?, rental_date = ?, return_date = ?, status = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, rental.getCarId());
            statement.setLong(2, rental.getCustomerId());
            statement.setObject(3, rental.getRentalDate());
            statement.setObject(4, rental.getReturnDate());
            statement.setString(5, rental.getStatus());
            statement.setLong(6, rental.getId());
            statement.executeUpdate();
        }
    }

    // Method to delete a rental by id
    public void deleteRental(Long rentalId) throws SQLException {
        String query = "DELETE FROM rental WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, rentalId);
            statement.executeUpdate();
        }
    }

    // Method to retrieve a rental by id
    public Rental getRentalById(Long rentalId) throws SQLException {
        String query = "SELECT * FROM rental WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, rentalId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return extractRentalFromResultSet(resultSet);
                }
            }
        }
        return null; // Rental not found
    }

    // Method to retrieve all rentals
    public List<Rental> getAllRentals() throws SQLException {
        List<Rental> rentals = new ArrayList<>();
        String query = "SELECT * FROM rental";
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                rentals.add(extractRentalFromResultSet(resultSet));
            }
        }
        return rentals;
    }

    // Helper method to extract rental data from ResultSet
    private Rental extractRentalFromResultSet(ResultSet resultSet) throws SQLException {
        Rental rental = new Rental();
        rental.setId(resultSet.getLong("id"));
        rental.setCarId(resultSet.getLong("car_id"));
        rental.setCustomerId(resultSet.getLong("customer_id"));
        rental.setRentalDate(resultSet.getObject("rental_date", LocalDate.class));
        rental.setReturnDate(resultSet.getObject("return_date", LocalDate.class));
        rental.setStatus(resultSet.getString("status"));
        return rental;
    }
}
