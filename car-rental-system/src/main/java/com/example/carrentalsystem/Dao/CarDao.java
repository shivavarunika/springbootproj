package com.example.carrentalsystem.Dao;

import com.example.carrentalsystem.model.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDao {
    private Connection connection;

    // Default constructor (Spring Boot requires this if not defining beans explicitly)
    public CarDao() {}

    // Constructor with JDBC connection initialization
    public CarDao(Connection connection) {
        this.connection = connection;
    }

 
    // Method to add a new car
    public void addCar(Car car) throws SQLException {
        String query = "INSERT INTO car (make, model, year, status) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, car.getMake());
            statement.setString(2, car.getModel());
            statement.setInt(3, car.getYear());
            statement.setString(4, car.getStatus());
            statement.executeUpdate();

            // Retrieve auto-generated key (id)
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                car.setId(generatedKeys.getLong(1));
            }
        }
    }

    // Method to update an existing car
    public void updateCar(Car car) throws SQLException {
        String query = "UPDATE car SET make = ?, model = ?, year = ?, status = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, car.getMake());
            statement.setString(2, car.getModel());
            statement.setInt(3, car.getYear());
            statement.setString(4, car.getStatus());
            statement.setLong(5, car.getId());
            statement.executeUpdate();
        }
    }

    // Method to delete a car by id
    public void deleteCar(Long carId) throws SQLException {
        String query = "DELETE FROM car WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, carId);
            statement.executeUpdate();
        }
    }

    // Method to retrieve a car by id
    public Car getCarById(Long carId) throws SQLException {
        String query = "SELECT * FROM car WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, carId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return extractCarFromResultSet(resultSet);
                }
            }
        }
        return null; // Car not found
    }

    // Method to retrieve all cars
    public List<Car> getAllCars() throws SQLException {
        List<Car> cars = new ArrayList<>();
        String query = "SELECT * FROM car";
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                cars.add(extractCarFromResultSet(resultSet));
            }
        }
        return cars;
    }

    // Helper method to extract car data from ResultSet
    private Car extractCarFromResultSet(ResultSet resultSet) throws SQLException {
        Car car = new Car();
        car.setId(resultSet.getLong("id"));
        car.setMake(resultSet.getString("make"));
        car.setModel(resultSet.getString("model"));
        car.setYear(resultSet.getInt("year"));
        car.setStatus(resultSet.getString("status"));
        return car;
    }
}

//package com.example.carrentalsystem.Dao;
//
//import com.example.carrentalsystem.model.Car;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class CarDao {
//    private Connection connection;
//
//    // Constructor with JDBC connection initialization
//    public CarDao(Connection connection) {
//        this.connection = connection;
//    }
//
//    // Method to add a new car
//    public void addCar(Car car) throws SQLException {
//        String query = "INSERT INTO car (make, model, year, status) VALUES (?, ?, ?, ?)";
//        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
//            statement.setString(1, car.getMake());
//            statement.setString(2, car.getModel());
//            statement.setInt(3, car.getYear());
//            statement.setString(4, car.getStatus());
//            statement.executeUpdate();
//
//            // Retrieve auto-generated key (id)
//            ResultSet generatedKeys = statement.getGeneratedKeys();
//            if (generatedKeys.next()) {
//                car.setId(generatedKeys.getLong(1));
//            }
//        }
//    }
//
//    // Method to update an existing car
//    public void updateCar(Car car) throws SQLException {
//        String query = "UPDATE car SET make = ?, model = ?, year = ?, status = ? WHERE id = ?";
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setString(1, car.getMake());
//            statement.setString(2, car.getModel());
//            statement.setInt(3, car.getYear());
//            statement.setString(4, car.getStatus());
//            statement.setLong(5, car.getId());
//            statement.executeUpdate();
//        }
//    }
//
//    // Method to delete a car by id
//    public void deleteCar(Long carId) throws SQLException {
//        String query = "DELETE FROM car WHERE id = ?";
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setLong(1, carId);
//            statement.executeUpdate();
//        }
//    }
//
//    // Method to retrieve a car by id
//    public Car getCarById(Long carId) throws SQLException {
//        String query = "SELECT * FROM car WHERE id = ?";
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setLong(1, carId);
//            try (ResultSet resultSet = statement.executeQuery()) {
//                if (resultSet.next()) {
//                    return extractCarFromResultSet(resultSet);
//                }
//            }
//        }
//        return null; // Car not found
//    }
//
//    // Method to retrieve all cars
//    public List<Car> getAllCars() throws SQLException {
//        List<Car> cars = new ArrayList<>();
//        String query = "SELECT * FROM car";
//        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
//            while (resultSet.next()) {
//                cars.add(extractCarFromResultSet(resultSet));
//            }
//        }
//        return cars;
//    }
//
//    // Helper method to extract car data from ResultSet
//    private Car extractCarFromResultSet(ResultSet resultSet) throws SQLException {
//        Car car = new Car();
//        car.setId(resultSet.getLong("id"));
//        car.setMake(resultSet.getString("make"));
//        car.setModel(resultSet.getString("model"));
//        car.setYear(resultSet.getInt("year"));
//        car.setStatus(resultSet.getString("status"));
//        return car;
//    }
//}
