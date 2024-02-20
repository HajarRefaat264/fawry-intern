package com.fawry.employeedepartment.controller;

import com.fawry.employeedepartment.common.EmployeeModel;
import com.fawry.employeedepartment.entity.EmployeeEntity;
import com.fawry.employeedepartment.entity.DepartmentEntity;
import com.fawry.employeedepartment.service.DepartmentServiceImpl;
import com.fawry.employeedepartment.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;
    @Autowired
    DepartmentServiceImpl departmentService;

    @GetMapping
    public List<EmployeeEntity> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeEntity getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/byDepartment/{id}")
    public List<EmployeeEntity> getEmployeesByDepartment(@PathVariable Long id) {
        return employeeService.getEmployeesByDepartment(id);
    }
    @GetMapping("/search")
    public List<EmployeeEntity> searchEmployees(@RequestParam String query) {
        return employeeService.searchEmployees(query);
    }
    @GetMapping("/all")
    public Page<EmployeeEntity> getAllEmployees(@RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return employeeService.getAllEmployees(pageable);
    }
    @PostMapping("/create")
    public EmployeeEntity createEmployee(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam Long departmentId
    ) {
        EmployeeEntity employee = new EmployeeEntity();
        employee.setFirst_name(firstName);
        employee.setLast_name(lastName);


//        DepartmentEntity department = new DepartmentEntity();
//        department.setId(departmentId);
       // employee.setDepartment(department);


         DepartmentEntity departmentanother = departmentService.findById(departmentId);
         employee.setDepartment(departmentanother);

        return employeeService.saveEmployee(employee);
    }
}