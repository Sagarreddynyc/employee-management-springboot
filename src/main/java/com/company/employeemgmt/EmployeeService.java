package com.company.employeemgmt;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public Employee addEmployee(Employee emp) {
        return repo.save(emp);
    }

    public List<Employee> getEmployees() {
        return repo.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public boolean deleteEmployeeById(Long id) {
        if (!repo.existsById(id)) {
            return false;
        }
        repo.deleteById(id);
        return true;
    }

    public boolean updateEmployee(Long id, String name, String department) {
        return repo.findById(id).map(emp -> {
            if (name != null && !name.trim().isEmpty()) {
                emp.setName(name);
            }
            if (department != null && !department.trim().isEmpty()) {
                emp.setDepartment(department);
            }
            repo.save(emp);
            return true;
        }).orElse(false);
    }
}