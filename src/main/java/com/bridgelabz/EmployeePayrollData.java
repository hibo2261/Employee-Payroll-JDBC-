package com.bridgelabz;

import java.sql.Date;
import java.util.Objects;


public class EmployeePayrollData {
    /*
     * variables to store employee data
     */
    int id;
    String name;
    double salary;
    Date startDate;

    /**
     *  Created constructor with parameters (int employeeId, String name, double salary, Date startDate)
     */
    public EmployeePayrollData(int employeeId, String name, double salary, Date startDate) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.startDate = startDate;
    }

    /**
     *  Override toString method to print employee data
     */
    @Override
    public String toString() {
        return "EmployeePayrollData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", startDate=" + startDate +
                '}';
    }

    /**
     * Override equals method compare objects of class EmployeePayrollData
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeePayrollData that = (EmployeePayrollData) o;
        return id == that.id && Double.compare(that.salary, salary) == 0 && Objects.equals(name, that.name) && Objects.equals(startDate, that.startDate);
    }
}