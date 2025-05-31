package com.v2u.employeemng.controller;

import com.v2u.employeemng.dto.EmployeeDTO;
import com.v2u.employeemng.service.EmployeeCompositeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
@Tag(name = "Employee Management", description = "APIs for Employee management")
public class EmployeeCompositeController {

    private final EmployeeCompositeService service;

    @PostMapping
    public ResponseEntity<String> createEmployee(@RequestBody EmployeeDTO request) {
        service.createEmployee(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Employee created");
    }

    @Operation(summary = "Get Employee by Employee Id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Employee found",content = @Content(schema = @Schema(implementation = EmployeeDTO.class))),
            @ApiResponse(responseCode = "404", description = "Employee not found")
    })
    @GetMapping("/{empID}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable String empID) {
        return ResponseEntity.ok(service.getEmployee(empID));
    }

    @Operation(summary = "Get all employees", description = "Retrieve a paginated list of all employees")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Employees found",content = @Content(schema = @Schema(implementation = EmployeeDTO.class))),
            @ApiResponse(responseCode = "404", description = "Employee not found")
    })
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        return ResponseEntity.ok(service.getAllEmployees());
    }

    @Operation(summary = "Update Employee by Employee Id", description = "Update Employee by Employee Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee updated",
                    content = @Content(schema = @Schema(implementation = EmployeeDTO.class))),
            @ApiResponse(responseCode = "404", description = "Employee not found"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PutMapping("/{empID}")
    public ResponseEntity<String> updateEmployee(@PathVariable String empID,
                                                 @RequestBody EmployeeDTO request) {
        service.updateEmployee(empID, request);
        return ResponseEntity.ok("Employee updated");
    }

    /*@DeleteMapping("/{empID}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String empID) {
        service.deleteEmployee(empID);
        return ResponseEntity.ok("Employee deleted");
    }*/
}

