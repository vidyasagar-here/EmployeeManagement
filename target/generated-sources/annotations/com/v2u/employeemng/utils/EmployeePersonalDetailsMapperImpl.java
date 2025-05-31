package com.v2u.employeemng.utils;

import com.v2u.employeemng.dto.EmployeePersonalDetailsDTO;
import com.v2u.employeemng.entity.EmployeePersonalDetails;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-31T20:01:48+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class EmployeePersonalDetailsMapperImpl implements EmployeePersonalDetailsMapper {

    @Override
    public EmployeePersonalDetailsDTO toDto(EmployeePersonalDetails entity) {
        if ( entity == null ) {
            return null;
        }

        EmployeePersonalDetailsDTO employeePersonalDetailsDTO = new EmployeePersonalDetailsDTO();

        employeePersonalDetailsDTO.setEmpID( entity.getEmpID() );
        employeePersonalDetailsDTO.setFirstName( entity.getFirstName() );
        employeePersonalDetailsDTO.setLastName( entity.getLastName() );
        employeePersonalDetailsDTO.setDateOfBirth( entity.getDateOfBirth() );
        employeePersonalDetailsDTO.setGender( genderToGender( entity.getGender() ) );
        employeePersonalDetailsDTO.setEmail( entity.getEmail() );
        employeePersonalDetailsDTO.setPhone( entity.getPhone() );
        employeePersonalDetailsDTO.setAddress( entity.getAddress() );

        return employeePersonalDetailsDTO;
    }

    @Override
    public EmployeePersonalDetails toEntity(EmployeePersonalDetailsDTO dto) {
        if ( dto == null ) {
            return null;
        }

        EmployeePersonalDetails employeePersonalDetails = new EmployeePersonalDetails();

        employeePersonalDetails.setEmpID( dto.getEmpID() );
        employeePersonalDetails.setFirstName( dto.getFirstName() );
        employeePersonalDetails.setLastName( dto.getLastName() );
        employeePersonalDetails.setDateOfBirth( dto.getDateOfBirth() );
        employeePersonalDetails.setGender( genderToGender1( dto.getGender() ) );
        employeePersonalDetails.setEmail( dto.getEmail() );
        employeePersonalDetails.setPhone( dto.getPhone() );
        employeePersonalDetails.setAddress( dto.getAddress() );

        return employeePersonalDetails;
    }

    @Override
    public void updateEntityFromDTO(EmployeePersonalDetailsDTO dto, EmployeePersonalDetails entity) {
        if ( dto == null ) {
            return;
        }

        entity.setEmpID( dto.getEmpID() );
        entity.setFirstName( dto.getFirstName() );
        entity.setLastName( dto.getLastName() );
        entity.setDateOfBirth( dto.getDateOfBirth() );
        entity.setGender( genderToGender1( dto.getGender() ) );
        entity.setEmail( dto.getEmail() );
        entity.setPhone( dto.getPhone() );
        entity.setAddress( dto.getAddress() );
    }

    protected EmployeePersonalDetailsDTO.Gender genderToGender(EmployeePersonalDetails.Gender gender) {
        if ( gender == null ) {
            return null;
        }

        EmployeePersonalDetailsDTO.Gender gender1;

        switch ( gender ) {
            case Male: gender1 = EmployeePersonalDetailsDTO.Gender.Male;
            break;
            case Female: gender1 = EmployeePersonalDetailsDTO.Gender.Female;
            break;
            case Other: gender1 = EmployeePersonalDetailsDTO.Gender.Other;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + gender );
        }

        return gender1;
    }

    protected EmployeePersonalDetails.Gender genderToGender1(EmployeePersonalDetailsDTO.Gender gender) {
        if ( gender == null ) {
            return null;
        }

        EmployeePersonalDetails.Gender gender1;

        switch ( gender ) {
            case Male: gender1 = EmployeePersonalDetails.Gender.Male;
            break;
            case Female: gender1 = EmployeePersonalDetails.Gender.Female;
            break;
            case Other: gender1 = EmployeePersonalDetails.Gender.Other;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + gender );
        }

        return gender1;
    }
}
