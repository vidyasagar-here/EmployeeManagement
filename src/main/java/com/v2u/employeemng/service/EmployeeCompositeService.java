package com.v2u.employeemng.service;

import com.v2u.employeemng.dto.EmployeeDTO;
import com.v2u.employeemng.dto.EmployeeDetailsDTO;
import com.v2u.employeemng.dto.EmployeePersonalDetailsDTO;
import com.v2u.employeemng.dto.EmployeeSalaryDetailsDTO;
import com.v2u.employeemng.entity.EmployeeDetails;
import com.v2u.employeemng.entity.EmployeePersonalDetails;
import com.v2u.employeemng.entity.EmployeeSalaryDetails;
import com.v2u.employeemng.repository.EmployeeDetailsRepository;
import com.v2u.employeemng.repository.EmployeePersonalDetailsRepository;
import com.v2u.employeemng.repository.EmployeeSalaryDetailsRepository;
import com.v2u.employeemng.utils.DepartmentMapper;
import com.v2u.employeemng.utils.EmployeeDetailsMapper;
import com.v2u.employeemng.utils.EmployeePersonalDetailsMapper;
import com.v2u.employeemng.utils.EmployeeSalaryDetailsMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeCompositeService {

    private final EmployeePersonalDetailsRepository personalRepo;
    private final EmployeeDetailsRepository detailsRepo;
    private final EmployeeSalaryDetailsRepository salaryRepo;
    private final EmployeePersonalDetailsMapper empPersonalDetailMapper;
    private final EmployeeDetailsMapper empDetailMapper;
    private final DepartmentMapper departmentMapper;
    private final EmployeeSalaryDetailsMapper empSalaryDetailsMapper;


    @Transactional
    public void createEmployee(EmployeeDTO request) {
        EmployeePersonalDetails personal = mapPersonal(request.getPersonalDetails());
        personalRepo.save(personal);
        EmployeeDetails details = empDetailMapper.toEntity(request.getDetails());
        personal = personalRepo.findByEmpID(request.getPersonalDetails().getEmpID()).orElseThrow(()->new RuntimeException(" Employee Personal Details Not Found "));
        details.setEmployee(personal);
        detailsRepo.save(details);

        EmployeeSalaryDetails salary = mapSalary(request.getSalaryDetails());
        salary.setEmployee(personal);
        salaryRepo.save(salary);

    }

    public EmployeeDTO getEmployee(String empID) {
        EmployeePersonalDetails personal = personalRepo.findByEmpID(empID).orElseThrow(() -> new RuntimeException("Employee not found"));

        EmployeeDetails details = detailsRepo.findByEmpID(empID).orElse(null);
        EmployeeSalaryDetails salary = salaryRepo.findByEmpID(empID).orElse(null);

        return toRequestDTO(personal, details, salary);
    }

    public List<EmployeeDTO> getAllEmployees() {
        return personalRepo.findAll().stream().map(personal -> {
            var details = detailsRepo.findByEmpID(personal.getEmpID()).orElse(null);
            var salary = salaryRepo.findByEmpID(personal.getEmpID()).orElse(null);
            return toRequestDTO(personal, details, salary);
        }).toList();
    }
    @Transactional
    public void updateEmployee(String empID, EmployeeDTO request) {
        if (!personalRepo.existsByEmpID(empID)) {
            throw new RuntimeException("Employee not found");
        }
        EmployeePersonalDetails existingPersonal = personalRepo.findByEmpID(empID).orElse(null);
        empPersonalDetailMapper.updateEntityFromDTO(request.getPersonalDetails(), existingPersonal);
        assert existingPersonal != null;
        personalRepo.save(existingPersonal);
        EmployeeDetails existingDetails = detailsRepo.findByEmpID(empID).orElse(null);
        empDetailMapper.updateEntityFromDTO(request.getDetails(), existingDetails);
        assert existingDetails != null;
        detailsRepo.save(existingDetails);
        EmployeeSalaryDetails existingSalary = salaryRepo.findByEmpID(empID).orElse(null);
        empSalaryDetailsMapper.updateEntityFromDTO(request.getSalaryDetails(), existingSalary);
        assert existingSalary != null;
        salaryRepo.save(existingSalary);
    }

//    public void deleteEmployee(String empID) {
//        salaryRepo.deleteByEmpID(empID);
//        detailsRepo.deleteByEmpID(empID);
//        personalRepo.deleteById(empID);
//    }

    // Mapping Methods

    private EmployeePersonalDetails mapPersonal(EmployeePersonalDetailsDTO dto) {
        // MapStruct
        return empPersonalDetailMapper.toEntity(dto);
    }

    private EmployeeDetails mapDetails(EmployeeDetailsDTO dto) {
        return empDetailMapper.toEntity(dto);
    }

    private EmployeeSalaryDetails mapSalary(EmployeeSalaryDetailsDTO dto) {
        return empSalaryDetailsMapper.toEntity(dto);
    }

    private EmployeeDTO toRequestDTO(EmployeePersonalDetails personal, EmployeeDetails details, EmployeeSalaryDetails salary) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setPersonalDetails(empPersonalDetailMapper.toDto(personal));
        dto.setDetails(empDetailMapper.toDto(details));
        dto.setSalaryDetails(empSalaryDetailsMapper.toDto(salary));
        return dto;
    }
}

