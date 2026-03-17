package com.company.employeemgmt.dto;

public class EmployeeUpdateRequest {
    private String name;
    private String department;

    public EmployeeUpdateRequest() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
}