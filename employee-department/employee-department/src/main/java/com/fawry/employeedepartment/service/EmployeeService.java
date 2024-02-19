package com.fawry.employeedepartment.service;

import com.fawry.employeedepartment.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    public List<EmployeeEntity> getAllEmployees();
    public EmployeeEntity getEmployeeById(Long id);
    public List<EmployeeEntity> getEmployeesByDepartment(Long departmentId);
}
