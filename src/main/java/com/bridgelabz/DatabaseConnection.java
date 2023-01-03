package com.bridgelabz;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        String url = "jdbc:mysql://localhost/payroll";
        String username = "root";
        String password = "admin";


        Connection connection;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("DRIVER LOADING DONE.");

        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("connection is sucessful..." + connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
