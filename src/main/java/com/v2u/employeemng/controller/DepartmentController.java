package com.v2u.employeemng.controller;


import com.v2u.employeemng.dto.DepartmentRequestDTO;
import com.v2u.employeemng.dto.DepartmentResponseDTO;
import com.v2u.employeemng.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
@Tag(name = "Department Management", description = "APIs for managing Department details")
@RequiredArgsConstructor
public class DepartmentController {

    public final DepartmentService departmentService;

    @Operation(summary = "Get Department by DepartmentName")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Department found",content = @Content(schema = @Schema(implementation = DepartmentResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Department not found")
    })
    @GetMapping("/{deptName}")
    public DepartmentResponseDTO getDepartment(@PathVariable String deptName) {
        return departmentService.getDepartmentByName(deptName);
    }

    @Operation(summary = "Get all Departments", description = "Retrieve a paginated list of all employees")
    @GetMapping
    public List<DepartmentResponseDTO> getDepartments() {
        return departmentService.getAllDepartments();
    }

    @PostMapping
    public ResponseEntity<DepartmentResponseDTO> createDepartment(@RequestBody @Valid DepartmentRequestDTO dto) {
        return new ResponseEntity<>(departmentService.createDepartment(dto), HttpStatus.CREATED);
    }

    @Operation(summary = "Update department by ID", description = "Update department name and location by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Department updated",
                    content = @Content(schema = @Schema(implementation = DepartmentResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Department not found"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PutMapping("/{id}")
    public ResponseEntity<DepartmentResponseDTO> update(@PathVariable Integer id, @RequestBody @Valid DepartmentRequestDTO dto) {
        return ResponseEntity.ok(departmentService.updateDepartment(id,dto));
    }
}
