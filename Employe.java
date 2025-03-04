package com.example.signinform;

import java.time.LocalDate;

public class Employe {
    private int id;
    private String firstName;
    private String lastName;
    private double salary;
    private String department;
    private boolean isFullTime;
    private boolean isPartTime;
    private LocalDate hireDate;

    public Employe(int id, String firstName, String lastName,
                   double salary, String department,
                   boolean isFullTime, boolean isPartTime, LocalDate hireDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
        this.isFullTime = isFullTime;
        this.isPartTime = isPartTime;
        this.hireDate = hireDate;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    public boolean isFullTime() {
        return isFullTime;
    }
    public void setFullTime(boolean fullTime) {
        isFullTime = fullTime;
    }

    public boolean isPartTime() {
        return isPartTime;
    }
    public void setPartTime(boolean partTime) {
        isPartTime = partTime;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }
    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }
}