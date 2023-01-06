package com.bridgelabz;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class EmployeePayrollService {
    /**
     *  Method to get all employee payroll data
     */
    public void readEmployeePayrollData() throws SQLException {
        PreparedStatement preparedStatement = DatabaseConnection.connection.prepareStatement("select * from Employee_Payroll");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println("\n *********************************");
            System.out.println("\n id   : " + resultSet.getString("id"));
            System.out.println(" name : " + resultSet.getString("name"));
            System.out.println(" phone_number      : " + resultSet.getString("phone_number"));
            System.out.println(" address  : " + resultSet.getString("address"));
            System.out.println(" department   : " + resultSet.getString("department"));
            System.out.println(" basic_pay       : " + resultSet.getString("basic_pay"));
            System.out.println(" deductions    : " + resultSet.getString("deductions"));
            System.out.println(" taxable_pay     : " + resultSet.getString("taxable_pay"));

        }
        System.out.println("\n *********************************");
    }
}