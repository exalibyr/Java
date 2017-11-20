package com.company;

public class Employee {
    private String name;
    private EmployeeSchedule employeeSchedule;

    public Employee(String name, EmployeeSchedule employeeSchedule) {
        this.name = name;
        this.employeeSchedule = employeeSchedule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeSchedule getEmployeeSchedule() {
        return employeeSchedule;
    }

    public void setEmployeeSchedule(EmployeeSchedule employeeSchedule) {
        this.employeeSchedule = employeeSchedule;
    }
}
