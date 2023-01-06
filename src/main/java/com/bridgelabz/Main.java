package com.bridgelabz;
import java.sql.SQLException;
public class Main {
    public static void main(String[] args) {
        DatabaseConnection.connectToDatabase();
        DatabaseConnection.driversList();
        try {
            EmployeePayrollService employeePayrollService = new EmployeePayrollService();
            employeePayrollService.readEmployeePayrollData();
            employeePayrollService.updateBaseSalary("Nupur",34000);
            employeePayrollService.readEmployeePayrollData();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}