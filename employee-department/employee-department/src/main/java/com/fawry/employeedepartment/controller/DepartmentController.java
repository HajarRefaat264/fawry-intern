package com.fawry.employeedepartment.controller;
import com.fawry.employeedepartment.entity.DepartmentEntity;
import com.fawry.employeedepartment.repository.DepartmentRepository;
import com.fawry.employeedepartment.service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentServiceImpl departmentRepositoryService;

    @GetMapping
    public List<DepartmentEntity> getAllDepartmentsByName() {
        return departmentRepositoryService.getAllDepartments();
    }
}
