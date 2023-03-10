package com.bridgelabz;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;


public class DatabaseConnection {
    static Connection connection;
    /**
     * Method to make connection with payroll_service database
     */
    public static void connectToDatabase() {
        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_services";
        String username = "root";
        String password = "admin";
        try {
            System.out.println("\n Connecting to database : " + jdbcURL);
            connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println(" Connection is Successful : " + connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     *  Method to get list of drivers installed for JDBC connections
     */
    public static void driversList() {
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        System.out.println("\n List of drivers :");
        while ((driverList.hasMoreElements())) {
            Driver driver = (Driver) driverList.nextElement();
            System.out.println(" " + driver.getClass().getName());
        }
    }
}