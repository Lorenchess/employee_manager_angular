package com.lorenchess.demo.repository;

import com.lorenchess.demo.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
