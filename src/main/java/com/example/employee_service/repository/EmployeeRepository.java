package com.example.employee_service.repository;

import com.example.employee_service.dto.DepartmentAvgSalaryResponse;
import com.example.employee_service.dto.DepartmentCountResponse;
import com.example.employee_service.dto.SkillCountResponse;
import com.example.employee_service.model.Employee;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

    List<Employee> findByDepartment(String department);

    List<Employee> findBySkills(String skill);

    List<Employee> findByIsActiveTrue();

    List<Employee> findByExperienceGreaterThan(Integer years);


    @Aggregation(pipeline = {
            "{ $group: { _id: '$department', count: { $sum: 1 } } }",
            "{ $project: { _id: 0, department: '$_id', count: 1 } }"
    })
    List<DepartmentCountResponse> countByDepartment();

    @Aggregation(pipeline = {
            "{ $group: { _id: '$department', avgSalary: { $avg: '$salary' } } }",
            "{ $project: { _id: 0, department: '$_id', avgSalary: 1 } }"
    })
    List<DepartmentAvgSalaryResponse> avgSalaryByDepartment();

    @Aggregation(pipeline = {
            "{ $unwind: '$skills' }",
            "{ $group: { _id: '$skills', count: { $sum: 1 } } }",
            "{ $project: { _id: 0, skill: '$_id', count: 1 } }"
    })
    List<SkillCountResponse> countBySkill();
}
