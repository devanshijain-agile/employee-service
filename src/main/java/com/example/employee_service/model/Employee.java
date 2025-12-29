package com.example.employee_service.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "employees")
@CompoundIndex(def= "{'department': 1, 'experience': -1}")
public class Employee {

    @Id
    private String id;
    private String name;
    private Integer age;
    private String department;
    private List<String> skills;
    private Double salary;
    private Integer experience;
    private Boolean isActive;
    private LocalDateTime createdAt;

}
