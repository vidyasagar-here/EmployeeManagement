package com.v2u.employeemng.utils;

import com.v2u.employeemng.dto.EmployeeDetailsDTO;
import com.v2u.employeemng.entity.Department;
import com.v2u.employeemng.entity.EmployeeDetails;
import com.v2u.employeemng.entity.EmployeePersonalDetails;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-31T12:44:27+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class EmployeeDetailsMapperImpl implements EmployeeDetailsMapper {

    @Override
    public EmployeeDetailsDTO toDto(EmployeeDetails entity) {
        if ( entity == null ) {
            return null;
        }

        EmployeeDetailsDTO employeeDetailsDTO = new EmployeeDetailsDTO();

        employeeDetailsDTO.setEmpID( entityEmployeeEmpID( entity ) );
        employeeDetailsDTO.setDepartmentID( entityDepartmentDepartmentID( entity ) );
        employeeDetailsDTO.setJoinDate( entity.getJoinDate() );
        employeeDetailsDTO.setJobTitle( entity.getJobTitle() );

        return employeeDetailsDTO;
    }

    @Override
    public EmployeeDetails toEntity(EmployeeDetailsDTO dto) {
        if ( dto == null ) {
            return null;
        }

        EmployeeDetails employeeDetails = new EmployeeDetails();

        employeeDetails.setEmployee( employeeDetailsDTOToEmployeePersonalDetails( dto ) );
        employeeDetails.setDepartment( employeeDetailsDTOToDepartment( dto ) );
        employeeDetails.setJoinDate( dto.getJoinDate() );
        employeeDetails.setJobTitle( dto.getJobTitle() );

        return employeeDetails;
    }

    @Override
    public void updateEntityFromDTO(EmployeeDetailsDTO dto, EmployeeDetails entity) {
        if ( dto == null ) {
            return;
        }

        entity.setJoinDate( dto.getJoinDate() );
        entity.setJobTitle( dto.getJobTitle() );
    }

    private String entityEmployeeEmpID(EmployeeDetails employeeDetails) {
        if ( employeeDetails == null ) {
            return null;
        }
        EmployeePersonalDetails employee = employeeDetails.getEmployee();
        if ( employee == null ) {
            return null;
        }
        String empID = employee.getEmpID();
        if ( empID == null ) {
            return null;
        }
        return empID;
    }

    private Integer entityDepartmentDepartmentID(EmployeeDetails employeeDetails) {
        if ( employeeDetails == null ) {
            return null;
        }
        Department department = employeeDetails.getDepartment();
        if ( department == null ) {
            return null;
        }
        Integer departmentID = department.getDepartmentID();
        if ( departmentID == null ) {
            return null;
        }
        return departmentID;
    }

    protected EmployeePersonalDetails employeeDetailsDTOToEmployeePersonalDetails(EmployeeDetailsDTO employeeDetailsDTO) {
        if ( employeeDetailsDTO == null ) {
            return null;
        }

        EmployeePersonalDetails employeePersonalDetails = new EmployeePersonalDetails();

        employeePersonalDetails.setEmpID( employeeDetailsDTO.getEmpID() );

        return employeePersonalDetails;
    }

    protected Department employeeDetailsDTOToDepartment(EmployeeDetailsDTO employeeDetailsDTO) {
        if ( employeeDetailsDTO == null ) {
            return null;
        }

        Department department = new Department();

        department.setDepartmentID( employeeDetailsDTO.getDepartmentID() );

        return department;
    }
}
