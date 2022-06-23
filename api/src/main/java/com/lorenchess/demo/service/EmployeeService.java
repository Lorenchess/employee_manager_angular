package com.lorenchess.demo.service;

import com.lorenchess.demo.entities.Employee;
import com.lorenchess.demo.payloadDTO.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO addEmployee(EmployeeDTO employeeDTO);
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO findEmployeeById(Long id);
    EmployeeDTO updateEmployee(EmployeeDTO employeeDTO, Long id);
    void deleteEmployee(Long id);
}
