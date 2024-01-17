package org.example.spring_testing_demo.services;

import org.example.spring_testing_demo.models.Employee;
import org.example.spring_testing_demo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;

    public Iterable<Employee> getEmployees() {
        return repository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return repository.findById(id);
    }

    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }

    public Iterable<Employee> seedEmployees() {
        Employee[] employees = {
                new Employee("Aaa", 111111),
                new Employee("Bbb", 222222),
                new Employee("Ccc", 333333),
        };
        return repository.saveAll(Arrays.stream(employees).toList());
    }

    public Employee updateEmployeeById(Long id, Employee employee) {
        employee.setId(id);
        return repository.save(employee);
    }

    public boolean deleteEmployeeById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean deleteEmployees() {
        try {
            repository.deleteAll();
            return true;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
