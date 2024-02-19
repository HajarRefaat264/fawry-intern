package com.fawry.employeedepartment.repository;

import com.fawry.employeedepartment.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
    public List<DepartmentEntity> getAllDepartments() ;

}
