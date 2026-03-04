package com.company.employeemgmt;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
// Employee REST API Controller
//Employee REST API Controller - Git Practice
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    // Add employee
    @PostMapping("/add")
    public ResponseEntity<String> addEmployee(@RequestParam String name) {

        if (name == null || name.trim().isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Employee name cannot be empty");
        }

        service.addEmployee(new Employee(name));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Employee added successfully");
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
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {

        boolean deleted = service.deleteEmployeeById(id);

        if (deleted) {
            return ResponseEntity.ok("Employee deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Employee not found");
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(
            @PathVariable int id,
            @RequestParam String name) {

        if (name == null || name.trim().isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Employsee name cannot be empty");
        }

        boolean updated = service.updateEmployee(id, name);

        if (updated) {
            return ResponseEntity.ok("Employee updated successfully");
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Employee not found");
        }
    }



}
