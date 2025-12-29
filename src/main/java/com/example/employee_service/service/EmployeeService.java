package com.example.employee_service.service;

import com.example.employee_service.model.Employee;
import com.example.employee_service.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;

    public Employee create(Employee employee) {
        employee.setId(null); // let Mongo generate _id
        employee.setCreatedAt(LocalDateTime.now());
        employee.setIsActive(true);
        return repository.save(employee);
    }

    public List<Employee> getAll() {
        return repository.findAll();
    }

    public Employee getById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public Employee update(String id, Employee updatedEmployee) {
        Employee existing = getById(id);

        existing.setName(updatedEmployee.getName());
        existing.setAge(updatedEmployee.getAge());
        existing.setDepartment(updatedEmployee.getDepartment());
        existing.setSkills(updatedEmployee.getSkills());
        existing.setSalary(updatedEmployee.getSalary());
        existing.setExperience(updatedEmployee.getExperience());
        existing.setIsActive(updatedEmployee.getIsActive());

        return repository.save(existing);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public List<Employee> getByDepartment(String department) {
        return repository.findByDepartment(department);
    }

    public List<Employee> getBySkill(String skill) {
        return repository.findBySkills(skill);
    }

    public List<Employee> getActiveEmployees() {
        return repository.findByIsActiveTrue();
    }

    public List<Employee> getExperiencedEmployees(Integer years) {
        return repository.findByExperienceGreaterThan(years);
    }
}