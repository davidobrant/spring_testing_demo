package org.example.spring_testing_demo.repositories;

import org.example.spring_testing_demo.models.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
