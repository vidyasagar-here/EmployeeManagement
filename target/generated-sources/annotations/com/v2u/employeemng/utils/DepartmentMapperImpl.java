package com.v2u.employeemng.utils;

import com.v2u.employeemng.dto.DepartmentRequestDTO;
import com.v2u.employeemng.dto.DepartmentResponseDTO;
import com.v2u.employeemng.entity.Department;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-31T12:44:27+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class DepartmentMapperImpl implements DepartmentMapper {

    @Override
    public DepartmentResponseDTO toDto(Department department) {
        if ( department == null ) {
            return null;
        }

        DepartmentResponseDTO departmentResponseDTO = new DepartmentResponseDTO();

        departmentResponseDTO.setDepartmentID( department.getDepartmentID() );
        departmentResponseDTO.setDepartmentName( department.getDepartmentName() );
        departmentResponseDTO.setLocation( department.getLocation() );

        return departmentResponseDTO;
    }

    @Override
    public Department toEntity(DepartmentRequestDTO departmentRequestDTO) {
        if ( departmentRequestDTO == null ) {
            return null;
        }

        Department department = new Department();

        department.setDepartmentName( departmentRequestDTO.getDepartmentName() );
        department.setLocation( departmentRequestDTO.getLocation() );

        return department;
    }

    @Override
    public void updateEntityFromDTO(DepartmentRequestDTO dto, Department entity) {
        if ( dto == null ) {
            return;
        }

        entity.setDepartmentName( dto.getDepartmentName() );
        entity.setLocation( dto.getLocation() );
    }
}
