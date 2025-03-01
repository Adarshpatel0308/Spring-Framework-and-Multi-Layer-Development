package com.springpayroll.SpringPayrollApp.controller;

import com.springpayroll.SpringPayrollApp.dto.EmployeeRequestDTO;
import com.springpayroll.SpringPayrollApp.exception.EmployeeNotFoundException;
import com.springpayroll.SpringPayrollApp.model.Employee;
import com.springpayroll.SpringPayrollApp.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
@Slf4j  // Logging added here
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        try {
            log.info("Fetching employee with id: {}", id);
            Employee employee = employeeService.getEmployeeById(id);
            return ResponseEntity.ok(employee);
        } catch (EmployeeNotFoundException ex) {
            // Exception will be handled by GlobalExceptionHandler
            throw ex;
        }
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody EmployeeRequestDTO employeeDTO) {
        try {
            log.info("Creating new employee: {}", employeeDTO);
            Employee createdEmployee = employeeService.createEmployee(employeeDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
        } catch (Exception ex) {
            log.error("Error creating employee: {}", ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeRequestDTO employeeDTO) {
        try {
            log.info("Updating employee with id: {}", id);
            Employee updatedEmployee = employeeService.updateEmployee(id, employeeDTO);
            return ResponseEntity.ok(updatedEmployee);
        } catch (EmployeeNotFoundException ex) {
            // Exception will be handled by GlobalExceptionHandler
            throw ex;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        try {
            log.info("Deleting employee with id: {}", id);
            if (employeeService.deleteEmployee(id)) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (EmployeeNotFoundException ex) {
            // Exception will be handled by GlobalExceptionHandler
            throw ex;
        }
    }
}
