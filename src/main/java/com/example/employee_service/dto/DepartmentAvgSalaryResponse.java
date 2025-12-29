package com.example.employee_service.dto;

import lombok.Data;

@Data
public class DepartmentAvgSalaryResponse {

    private String department;
    private Double avgSalary;
}
