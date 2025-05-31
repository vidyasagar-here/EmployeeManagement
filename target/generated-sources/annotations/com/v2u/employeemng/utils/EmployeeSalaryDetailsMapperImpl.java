package com.v2u.employeemng.utils;

import com.v2u.employeemng.dto.EmployeeSalaryDetailsDTO;
import com.v2u.employeemng.entity.EmployeePersonalDetails;
import com.v2u.employeemng.entity.EmployeeSalaryDetails;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-31T12:44:27+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class EmployeeSalaryDetailsMapperImpl implements EmployeeSalaryDetailsMapper {

    @Override
    public EmployeeSalaryDetailsDTO toDto(EmployeeSalaryDetails entity) {
        if ( entity == null ) {
            return null;
        }

        EmployeeSalaryDetailsDTO employeeSalaryDetailsDTO = new EmployeeSalaryDetailsDTO();

        employeeSalaryDetailsDTO.setEmpID( entityEmployeeEmpID( entity ) );
        employeeSalaryDetailsDTO.setBasicSalary( entity.getBasicSalary() );
        employeeSalaryDetailsDTO.setBonus( entity.getBonus() );
        employeeSalaryDetailsDTO.setDeductions( entity.getDeductions() );
        employeeSalaryDetailsDTO.setEffectiveDate( entity.getEffectiveDate() );

        return employeeSalaryDetailsDTO;
    }

    @Override
    public EmployeeSalaryDetails toEntity(EmployeeSalaryDetailsDTO dto) {
        if ( dto == null ) {
            return null;
        }

        EmployeeSalaryDetails employeeSalaryDetails = new EmployeeSalaryDetails();

        employeeSalaryDetails.setEmployee( employeeSalaryDetailsDTOToEmployeePersonalDetails( dto ) );
        employeeSalaryDetails.setBasicSalary( dto.getBasicSalary() );
        employeeSalaryDetails.setBonus( dto.getBonus() );
        employeeSalaryDetails.setDeductions( dto.getDeductions() );
        employeeSalaryDetails.setEffectiveDate( dto.getEffectiveDate() );

        return employeeSalaryDetails;
    }

    @Override
    public void updateEntityFromDTO(EmployeeSalaryDetailsDTO dto, EmployeeSalaryDetails entity) {
        if ( dto == null ) {
            return;
        }

        entity.setBasicSalary( dto.getBasicSalary() );
        entity.setBonus( dto.getBonus() );
        entity.setDeductions( dto.getDeductions() );
        entity.setEffectiveDate( dto.getEffectiveDate() );
    }

    private String entityEmployeeEmpID(EmployeeSalaryDetails employeeSalaryDetails) {
        if ( employeeSalaryDetails == null ) {
            return null;
        }
        EmployeePersonalDetails employee = employeeSalaryDetails.getEmployee();
        if ( employee == null ) {
            return null;
        }
        String empID = employee.getEmpID();
        if ( empID == null ) {
            return null;
        }
        return empID;
    }

    protected EmployeePersonalDetails employeeSalaryDetailsDTOToEmployeePersonalDetails(EmployeeSalaryDetailsDTO employeeSalaryDetailsDTO) {
        if ( employeeSalaryDetailsDTO == null ) {
            return null;
        }

        EmployeePersonalDetails employeePersonalDetails = new EmployeePersonalDetails();

        employeePersonalDetails.setEmpID( employeeSalaryDetailsDTO.getEmpID() );

        return employeePersonalDetails;
    }
}
