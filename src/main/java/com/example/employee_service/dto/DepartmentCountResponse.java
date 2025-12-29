package com.example.employee_service.dto;

import lombok.Data;

@Data
public class DepartmentCountResponse {

    private String department;
    private Long count;
}
