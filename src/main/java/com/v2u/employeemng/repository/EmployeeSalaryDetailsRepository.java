package com.v2u.employeemng.repository;

import com.v2u.employeemng.entity.EmployeeSalaryDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeSalaryDetailsRepository extends JpaRepository<EmployeeSalaryDetails, Integer> {

    @Query(name ="EmployeeSalaryDetails.findByEmpID")
    Optional<EmployeeSalaryDetails> findByEmpID(@Param("empID") String employeeId);
}

