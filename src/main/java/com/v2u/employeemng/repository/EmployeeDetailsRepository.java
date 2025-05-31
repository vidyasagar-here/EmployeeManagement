package com.v2u.employeemng.repository;

import com.v2u.employeemng.entity.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Integer> {


    @Query(name = "EmployeeDetails.findByEmpID")
    Optional<EmployeeDetails> findByEmpID(@Param("empID") String employeeId);
}

