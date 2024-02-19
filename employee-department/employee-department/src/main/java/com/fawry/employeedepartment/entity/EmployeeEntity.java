package com.fawry.employeedepartment.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String first_name;
    private String last_name;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentEntity department;
}
