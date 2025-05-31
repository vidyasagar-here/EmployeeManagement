package com.v2u.employeemng.repository;

import com.v2u.employeemng.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    @Query(name="Department.findByDepartName")
    Optional<Department> findByDepartmentName(@Param("deptName") String DeptName);
}

