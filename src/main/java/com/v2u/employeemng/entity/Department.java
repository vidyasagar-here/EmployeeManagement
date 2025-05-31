package com.v2u.employeemng.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "Department" )
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Department.findByDepartName",
            query="select d from Department d where d.departmentName=:deptName")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer departmentID;

    @Column(unique = true, nullable = false)
    private String departmentName;

    private String location;

    private LocalDateTime createdAt = LocalDateTime.now();
}

