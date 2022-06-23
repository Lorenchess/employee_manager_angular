package com.lorenchess.demo.controller;

import com.lorenchess.demo.payloadDTO.EmployeeDTO;
import com.lorenchess.demo.service.EmployeeService;
import com.lorenchess.demo.service.EmployeeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;


    public EmployeeController( EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> allEmployees() {
        List<EmployeeDTO> allEmployees = employeeService.getAllEmployees();
        return new ResponseEntity<>(allEmployees, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO>getEmployeeById(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(employeeService.findEmployeeById(id), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
       return new ResponseEntity<>(employeeService.addEmployee(employeeDTO),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@Valid @RequestBody EmployeeDTO employeeDTO, @PathVariable(name = "id")Long id) {
        return new ResponseEntity<>(employeeService.updateEmployee(employeeDTO,id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable(name = "id") Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee with id= " + id + " was successfully deleted.", HttpStatus.OK);
    }




}
