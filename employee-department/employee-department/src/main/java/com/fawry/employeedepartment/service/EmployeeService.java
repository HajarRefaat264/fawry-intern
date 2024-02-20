package com.fawry.employeedepartment.service;

import com.fawry.employeedepartment.entity.EmployeeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    public List<EmployeeEntity> getAllEmployees();
    Page<EmployeeEntity> getAllEmployees(Pageable pageable);
    public EmployeeEntity getEmployeeById(Long id);
    public List<EmployeeEntity> getEmployeesByDepartment(Long departmentId);
    EmployeeEntity saveEmployee(EmployeeEntity employee);
    List<EmployeeEntity> searchEmployees(String query);
}
