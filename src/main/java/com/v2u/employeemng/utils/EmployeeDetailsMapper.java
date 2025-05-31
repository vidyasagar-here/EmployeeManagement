package com.v2u.employeemng.utils;


import com.v2u.employeemng.dto.EmployeeDetailsDTO;
import com.v2u.employeemng.entity.EmployeeDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EmployeeDetailsMapper {

    @Mapping(source = "employee.empID", target = "empID")
    @Mapping(source = "department.departmentID", target = "departmentID")
    EmployeeDetailsDTO toDto(EmployeeDetails entity);

    @Mapping(source = "empID", target = "employee.empID")
    @Mapping(source = "departmentID", target = "department.departmentID")
    EmployeeDetails toEntity(EmployeeDetailsDTO dto);

    void updateEntityFromDTO(EmployeeDetailsDTO dto, @MappingTarget EmployeeDetails entity);
}
