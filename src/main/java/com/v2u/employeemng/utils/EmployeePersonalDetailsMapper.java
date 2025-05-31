package com.v2u.employeemng.utils;

import com.v2u.employeemng.dto.EmployeePersonalDetailsDTO;
import com.v2u.employeemng.entity.EmployeePersonalDetails;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface EmployeePersonalDetailsMapper {

    EmployeePersonalDetailsDTO toDto(EmployeePersonalDetails entity);

    EmployeePersonalDetails toEntity(EmployeePersonalDetailsDTO dto);

    void updateEntityFromDTO(EmployeePersonalDetailsDTO dto, @MappingTarget EmployeePersonalDetails entity);
}

