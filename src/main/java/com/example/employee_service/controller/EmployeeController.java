package com.example.employee_service.controller;


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
}