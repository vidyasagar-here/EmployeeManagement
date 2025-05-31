package com.v2u.employeemng.service;

import com.v2u.employeemng.dto.EmployeePersonalDetailsDTO;
import com.v2u.employeemng.entity.EmployeePersonalDetails;
import com.v2u.employeemng.repository.EmployeePersonalDetailsRepository;
import com.v2u.employeemng.utils.EmployeePersonalDetailsMapper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
public class EmployeePersonalDetailsService {

    private final EmployeePersonalDetailsRepository repository;
    private final EmployeePersonalDetailsMapper mapper;

    public EmployeePersonalDetailsService(EmployeePersonalDetailsRepository repository, EmployeePersonalDetailsMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<EmployeePersonalDetailsDTO> getAllEmployees() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public EmployeePersonalDetailsDTO getEmployeeByEmpID(String empID) {
        return repository.findByEmpID(empID)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public EmployeePersonalDetailsDTO createEmployee(EmployeePersonalDetailsDTO dto) {
        EmployeePersonalDetails entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    public ByteArrayInputStream exportEmployeesToExcel(List<EmployeePersonalDetailsDTO> employees) throws IOException {
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Employees");

            // Header
            Row headerRow = sheet.createRow(0);
            String[] headers = {"EmpID", "First Name", "Last Name", "Email", "Phone"};
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
            }

            // Data rows
            int rowIdx = 1;
            for (EmployeePersonalDetailsDTO emp : employees) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(emp.getEmpID());
                row.createCell(1).setCellValue(emp.getFirstName());
                row.createCell(2).setCellValue(emp.getLastName());
                row.createCell(3).setCellValue(emp.getEmail());
                row.createCell(4).setCellValue(emp.getPhone());
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

}

