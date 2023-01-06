package com.bridgelabz;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmployeePayrollService {
    /**
     *  Method to get all employee payroll data
     */
    public int readEmployeePayrollData() throws SQLException {
        List<EmployeePayrollData> employeePayrollDataList = new ArrayList<>();
        String query = "select * from Employee_Payroll";
        PreparedStatement preparedStatement = DatabaseConnection.connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int employeeId = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int salary = resultSet.getInt("basic_pay");
            Date startDate = resultSet.getDate("StartDate");
            employeePayrollDataList.add(new EmployeePayrollData(employeeId, name, salary, startDate));
        }
        System.out.println("\n ****** Data of All Employees from employee_payroll table ***** \n");
        employeePayrollDataList.forEach(System.out::println);
        return employeePayrollDataList.size();
    }
    public String readAnyColumnDataByEmployeeName(String empName, String columnName) throws SQLException {
        String query = "select " + columnName + " from Employee_Payroll where name = ?";
        PreparedStatement preparedStatement = DatabaseConnection.connection.prepareStatement(query);
        preparedStatement.setString(1, empName);
        ResultSet resultSet = preparedStatement.executeQuery();
        String result = null;
        if (resultSet.next()) {
            result = resultSet.getString(columnName);
        }
        return result;
    }
    /**
     *  Method to update base salary of employee
     */
    public void updateBaseSalary(String name, double salary) throws SQLException {
        String query = "update Employee_Payroll set basic_pay = ? where name = ?";
        PreparedStatement preparedStatement = DatabaseConnection.connection.prepareStatement(query);
        preparedStatement.setDouble(1, salary);
        preparedStatement.setString(2, name);
        preparedStatement.executeUpdate();
    }
}