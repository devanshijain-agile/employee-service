package com.example.employee_service.controller;


import com.example.employee_service.dto.DepartmentAvgSalaryResponse;
import com.example.employee_service.dto.DepartmentCountResponse;
import com.example.employee_service.dto.SkillCountResponse;
import com.example.employee_service.model.Employee;
import com.example.employee_service.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return service.create(employee);
    }

    @GetMapping
    public List<Employee> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Employee update(
            @PathVariable String id,
            @RequestBody Employee employee) {
        return service.update(id, employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping("/department/{department}")
    public List<Employee> getByDepartment(@PathVariable String department) {
        return service.getByDepartment(department);
    }

    @GetMapping("/skill/{skill}")
    public List<Employee> getBySkill(@PathVariable String skill) {
        return service.getBySkill(skill);
    }

    @GetMapping("/active")
    public List<Employee> getActiveEmployees() {
        return service.getActiveEmployees();
    }

    @GetMapping("/experience/{years}")
    public List<Employee> getExperienced(@PathVariable Integer years) {
        return service.getExperiencedEmployees(years);
    }

    @GetMapping("/stats/count-by-department")
    public List<DepartmentCountResponse> countByDepartment() {
        return service.countByDepartment();
    }

    @GetMapping("/stats/avg-salary")
    public List<DepartmentAvgSalaryResponse> avgSalaryByDepartment() {
        return service.avgSalaryByDepartment();
    }

    @GetMapping("/stats/skills")
    public List<SkillCountResponse> countBySkill() {
        return service.countBySkill();
    }

}