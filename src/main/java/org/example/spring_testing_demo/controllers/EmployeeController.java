package org.example.spring_testing_demo.controllers;

import org.example.spring_testing_demo.models.Employee;
import org.example.spring_testing_demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/employees")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @GetMapping
    public Iterable<Employee> getEmployees() {
        return service.getEmployees();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    @PostMapping
    public Employee postEmployee(@RequestBody Employee employee) {
        return service.createEmployee(employee);
    }

    @PostMapping("/seed")
    public Iterable<Employee> seedEmployees() {
        return service.seedEmployees();
    }

    @PutMapping("/{id}")
    public Employee updateEmployeeById(@PathVariable Long id, @RequestBody Employee employee) {
        return service.updateEmployeeById(id, employee);
    }

    @DeleteMapping("/{id}")
    public boolean deleteEmployeeById(@PathVariable Long id) {
        return service.deleteEmployeeById(id);
    }

    @DeleteMapping("/all")
    public boolean deleteEmployees() {
        return service.deleteEmployees();
    }

}
