package com.v2u.employeemng.utils;

import com.v2u.employeemng.dto.DepartmentRequestDTO;
import com.v2u.employeemng.dto.DepartmentResponseDTO;
import com.v2u.employeemng.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    DepartmentResponseDTO toDto(Department department);
    Department toEntity(DepartmentRequestDTO departmentRequestDTO);
    void updateEntityFromDTO(DepartmentRequestDTO dto, @MappingTarget Department entity);
}
