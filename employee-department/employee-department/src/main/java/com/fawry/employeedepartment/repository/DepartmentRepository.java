package com.fawry.employeedepartment.repository;

import com.fawry.employeedepartment.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {


}
