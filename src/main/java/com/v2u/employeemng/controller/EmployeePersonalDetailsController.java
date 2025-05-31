package com.v2u.employeemng.controller;

import com.v2u.employeemng.dto.EmployeePersonalDetailsDTO;
import com.v2u.employeemng.service.EmployeePersonalDetailsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/emppersonal")
@Tag(name = "Employee Personal Details", description = "APIs for managing employee personal details")
@RequiredArgsConstructor
public class EmployeePersonalDetailsController {

    private final EmployeePersonalDetailsService service;

    @Operation(summary = "Get all employees", description = "Retrieve a paginated list of all employees")
    @GetMapping
    public List<EmployeePersonalDetailsDTO> getAllEmployees() {
        return service.getAllEmployees();
    }

    @Operation(summary = "Get employee personal details by EmpID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Employee found"),
            @ApiResponse(responseCode = "404", description = "Employee not found")
    })
    @GetMapping("/{empID}")
    public EmployeePersonalDetailsDTO getEmployee(@PathVariable String empID) {
        return service.getEmployeeByEmpID(empID);
    }

    @Operation(summary = "Create a new employee")
    @ApiResponse(responseCode = "201", description = "Employee created")
    @PostMapping
    public ResponseEntity<EmployeePersonalDetailsDTO> createEmployee(
            @Valid @RequestBody EmployeePersonalDetailsDTO dto) {
        return new ResponseEntity<>(service.createEmployee(dto), HttpStatus.CREATED);
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportEmployeesToExcel() throws IOException {
        List<EmployeePersonalDetailsDTO> employees = service.getAllEmployees();
        ByteArrayInputStream in = service.exportEmployeesToExcel(employees);

        InputStreamResource file = new InputStreamResource(in);
        String filename = "employees.xlsx";

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(file);
    }

}


