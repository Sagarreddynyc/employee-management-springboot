package com.company.employeemgmt;

public class Employee {
    private static int count = 0; // auto-increment ID
    private int id;
    private String name;

    public Employee(String name) {
        this.id = ++count;
        this.name = name;
    }

    // getters
    public int getId() { return id; }
    public String getName() { return name; }
}
