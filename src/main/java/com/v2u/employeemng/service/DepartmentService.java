package com.v2u.employeemng.service;

import com.v2u.employeemng.dto.DepartmentRequestDTO;
import com.v2u.employeemng.dto.DepartmentResponseDTO;
import com.v2u.employeemng.entity.Department;
import com.v2u.employeemng.exception.DepartmentNotFoundException;
import com.v2u.employeemng.repository.DepartmentRepository;
import com.v2u.employeemng.utils.DepartmentMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private DepartmentRepository repository;
    private DepartmentMapper mapper;

    public DepartmentService(DepartmentRepository repository, DepartmentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<DepartmentResponseDTO> getAllDepartments() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public DepartmentResponseDTO getDepartmentByName(String deptName) {
        return repository.findByDepartmentName(deptName)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Department not found"));
    }

    public DepartmentResponseDTO createDepartment(DepartmentRequestDTO dto) {
        Department entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    public DepartmentResponseDTO updateDepartment(Integer deptId,DepartmentRequestDTO dto) {
        Department existingDept = this.getById(deptId);
        mapper.updateEntityFromDTO(dto, existingDept);
        Department updated = repository.save(existingDept);
        return mapper.toDto(updated);
    }

    public Department getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException(id));
    }

}
