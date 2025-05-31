package com.v2u.employeemng.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeDetailsDTO {

    @NotBlank
    private String empID;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate joinDate;

    private String jobTitle;

    @NotNull
    private Integer departmentID;

    private String managerEmpID;
}

