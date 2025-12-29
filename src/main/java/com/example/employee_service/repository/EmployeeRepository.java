package com.example.employee_service.repository;

import com.example.employee_service.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

    List<Employee> findByDepartment(String department);

    List<Employee> findBySkills(String skill);

    List<Employee> findByIsActiveTrue();

    List<Employee> findByExperienceGreaterThan(Integer years);
}
