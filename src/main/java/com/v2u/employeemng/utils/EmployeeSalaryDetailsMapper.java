package com.v2u.employeemng.utils;


import com.v2u.employeemng.dto.EmployeeSalaryDetailsDTO;
import com.v2u.employeemng.entity.EmployeeSalaryDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EmployeeSalaryDetailsMapper {

    @Mapping(source = "employee.empID", target = "empID")
    EmployeeSalaryDetailsDTO toDto(EmployeeSalaryDetails entity);

    @Mapping(source = "empID", target = "employee.empID")
    EmployeeSalaryDetails toEntity(EmployeeSalaryDetailsDTO dto);

    void updateEntityFromDTO(EmployeeSalaryDetailsDTO dto, @MappingTarget EmployeeSalaryDetails entity);
}
