package com.lorenchess.demo.service;

import com.lorenchess.demo.exceptions.EmployeeNotFoundException;
import com.lorenchess.demo.entities.Employee;
import com.lorenchess.demo.payloadDTO.EmployeeDTO;
import com.lorenchess.demo.repository.EmployeeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepo employeeRepo;

    private final ModelMapper mapper;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo, ModelMapper mapper) {
        this.employeeRepo = employeeRepo;
        this.mapper = mapper;
    }


    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        employeeDTO.setEmployeeCode(generateRandomId());
        Employee employeeEntity = mapToEntity(employeeDTO);
        employeeRepo.save(employeeEntity);

        return mapToDTO(employeeEntity);
    }


    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepo.findAll();
        return employees.stream().map(employee -> mapToDTO(employee)).toList();
    }

    public EmployeeDTO findEmployeeById(Long id) {
        Employee employee = employeeRepo.findById(id).orElseThrow(() -> new EmployeeNotFoundException("User with id= " + id + " was not found."));
        return mapToDTO(employee);
    }


    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO, Long id) {
        Employee employeeEntity = employeeRepo.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee with id= " + id + " was not found."));
        employeeEntity.setName(employeeDTO.getName());
        employeeEntity.setJobTitle(employeeDTO.getJobTitle());
        employeeEntity.setEmail(employeeDTO.getEmail());
        employeeEntity.setPhoneNumber(employeeDTO.getPhoneNumber());
        employeeEntity.setEmployeeCode(employeeDTO.getEmployeeCode());
        employeeEntity.setImageUrl(employeeDTO.getImageUrl());
        employeeRepo.save(employeeEntity);
        return mapToDTO(employeeEntity);
    }


    public void deleteEmployee(Long id) {
        Employee employeeToDelete = employeeRepo.findById(id).orElseThrow(()-> new EmployeeNotFoundException("Employee with id= " + id + " was not found."));
        employeeRepo.delete(employeeToDelete);
    }

    //Helper methods
    private String generateRandomId() {
        return UUID.randomUUID().toString();
    }

    private Employee mapToEntity(EmployeeDTO employeeDTO) {
        return mapper.map(employeeDTO, Employee.class);
    }

    private EmployeeDTO mapToDTO(Employee employeeEntity) {
        return mapper.map(employeeEntity,EmployeeDTO.class);
    }


}
























