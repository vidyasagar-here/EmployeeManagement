package com.v2u.employeemng.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Employee_Salary_Details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery( name = "EmployeeSalaryDetails.findByEmpID",
            query = "Select ed from EmployeeSalaryDetails ed where ed.employee.empID=:empID")
public class EmployeeSalaryDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer salaryID;

    @ManyToOne
    @JoinColumn(name = "empID", referencedColumnName = "empID")
    private EmployeePersonalDetails employee;

    @Column(nullable = false)
    private BigDecimal basicSalary;

    private BigDecimal bonus = BigDecimal.ZERO;

    private BigDecimal deductions = BigDecimal.ZERO;

    @Column(nullable = false)
    private LocalDate effectiveDate;

    private LocalDateTime createdAt = LocalDateTime.now();
}
