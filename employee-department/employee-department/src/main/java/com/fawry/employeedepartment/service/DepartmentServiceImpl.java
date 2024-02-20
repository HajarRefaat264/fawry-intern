package com.fawry.employeedepartment.service;

import com.fawry.employeedepartment.entity.DepartmentEntity;
import com.fawry.employeedepartment.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;
    public DepartmentEntity findById(Long departmentId) {
        Optional<DepartmentEntity> optionalDepartment = departmentRepository.findById(departmentId);
        return optionalDepartment.orElse(null);
    }


    public List<DepartmentEntity> getAllDepartments() {
        return departmentRepository.findAll();
    }
}