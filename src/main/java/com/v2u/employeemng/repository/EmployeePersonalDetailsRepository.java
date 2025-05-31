package com.v2u.employeemng.repository;

import com.v2u.employeemng.entity.EmployeePersonalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeePersonalDetailsRepository extends JpaRepository<EmployeePersonalDetails, Integer> {

    @Query(name="EmployeePersonalDetails.findByEmpId")
    Optional<EmployeePersonalDetails> findByEmpID(@Param("empID") String empID);

    Boolean existsByEmpID(String empID);
}

