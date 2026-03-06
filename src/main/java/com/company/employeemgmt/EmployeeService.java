package com.company.employeemgmt;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    // CREATE
    public Employee addEmployee(Employee emp) {
        return repo.save(emp);
    }

    // READ ALL
    public List<Employee> getEmployees() {
        return repo.findAll();
    }

    // READ BY ID
    public Employee getEmployeeById(int id) {
        return repo.findById(id).orElse(null);
    }

    // DELETE
    public boolean deleteEmployeeById(int id) {
        if (!repo.existsById(id)) return false;
        repo.deleteById(id);
        return true;
    }

    // UPDATE NAME
    public boolean updateEmployee(int id, String name) {
        return repo.findById(id).map(emp -> {
            emp.setName(name);
            repo.save(emp);
            return true;
        }).orElse(false);
    }
}