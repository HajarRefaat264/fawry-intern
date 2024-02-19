package com.fawry.employeedepartment.controller;

import com.fawry.employeedepartment.entity.EmployeeEntity;

import com.fawry.employeedepartment.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping
    public List<EmployeeEntity> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeEntity getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/byDepartment/{departmentId}")
    public List<EmployeeEntity> getEmployeesByDepartment(@PathVariable Long departmentId) {
        return employeeService.getEmployeesByDepartment(departmentId);
    }
}