package com.company.employeemgmt;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee emp) { employees.add(emp); }

    public List<Employee> getEmployees() { return employees; }

    public Employee getEmployeeById(int id) {
        return employees.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }
}
