package com.v2u.employeemng.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(description = "DTO representing a department")
public class DepartmentResponseDTO {

    @Schema(description = "Department ID", example = "1")
    private Integer departmentID;

    @NotBlank
    @Schema(description = "Department name", example = "HR")
    private String departmentName;

    @Schema(description = "Department location", example = "India/Bangalore")
    private String location;
}

