package com.company.employeemgmt;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    // Add employee
    @PostMapping("/add")
    public String addEmployee(@RequestParam String name) {
        service.addEmployee(new Employee(name));
        return "Employee added: " + name;
    }

    // List all employees
    @GetMapping
    public List<Employee> getEmployees() {
        return service.getEmployees();
    }

    // Search employee by ID
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return service.getEmployeeById(id);
    }
}
