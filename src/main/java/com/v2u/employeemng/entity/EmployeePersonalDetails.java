package com.v2u.employeemng.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "Employee_Personal_Details")
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="EmployeePersonalDetails.findByEmpId",
            query="select epd from EmployeePersonalDetails epd where epd.empID=:empID")
@NamedQuery(name="EmployeePersonalDetails.findAll",
        query="select epd from EmployeePersonalDetails epd ")
public class EmployeePersonalDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer peopleSoftId;

    @Column(unique = true, nullable = false)
    private String empID;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(unique = true)
    private String email;

    private String phone;

    @Column(columnDefinition = "TEXT")
    private String address;

    private LocalDateTime createdAt = LocalDateTime.now();

    public enum Gender {
        Male, Female, Other
    }

}
