package com.v2u.employeemng.dto;

import lombok.Data;

@Data
public class EmployeeDTO {

    private EmployeePersonalDetailsDTO personalDetails;
    private EmployeeDetailsDTO details;
    private EmployeeSalaryDetailsDTO salaryDetails;
}
