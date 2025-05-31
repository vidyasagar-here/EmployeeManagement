package com.v2u.employeemng.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class EmployeeSalaryDetailsDTO {

    @NotBlank
    private String empID;

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal basicSalary;

    @DecimalMin("0.0")
    private BigDecimal bonus = BigDecimal.ZERO;

    @DecimalMin("0.0")
    private BigDecimal deductions = BigDecimal.ZERO;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate effectiveDate;
}

