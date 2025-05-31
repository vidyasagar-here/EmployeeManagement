package com.v2u.employeemng.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Employee_Details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="EmployeeDetails.findByEmpID",
        query="select d from EmployeeDetails d where d.employee.empID=:empID")
public class EmployeeDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer detailID;

    @OneToOne
    @JoinColumn(name = "empID", referencedColumnName = "empID")
    private EmployeePersonalDetails employee;

    @Column(nullable = false)
    private LocalDate joinDate;

    private String jobTitle;

    @ManyToOne
    @JoinColumn(name = "departmentID",referencedColumnName = "departmentID")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "managerEmpID", referencedColumnName = "empID")
    private EmployeePersonalDetails manager;

    private LocalDateTime createdAt = LocalDateTime.now();
}

