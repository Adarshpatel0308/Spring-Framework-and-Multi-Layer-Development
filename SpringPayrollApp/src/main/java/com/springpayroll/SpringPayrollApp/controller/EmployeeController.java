package com.springpayroll.SpringPayrollApp.controller;

import com.springpayroll.SpringPayrollApp.model.Employee;
import com.springpayroll.SpringPayrollApp.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;  // Import the SLF4J annotation
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        log.info("Fetching all employees.");
        List<Employee> employees = employeeService.getAllEmployees();
        log.info("Successfully fetched {} employees.", employees.size());
        return employees;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        log.info("Fetching employee with id: {}", id);
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        if (employee.isPresent()) {
            log.info("Successfully fetched employee with id: {}", id);
            return ResponseEntity.ok(employee.get());
        } else {
            log.warn("Employee with id {} not found", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        log.info("Creating new employee: {}", employee);
        Employee createdEmployee = employeeService.createEmployee(employee);
        log.info("Successfully created employee with id: {}", createdEmployee.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        log.info("Updating employee with id: {}", id);
        Employee updatedEmployee = employeeService.updateEmployee(id, employee);
        if (updatedEmployee != null) {
            log.info("Successfully updated employee with id: {}", id);
            return ResponseEntity.ok(updatedEmployee);
        } else {
            log.warn("Employee with id {} not found for update", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        log.info("Deleting employee with id: {}", id);
        if (employeeService.deleteEmployee(id)) {
            log.info("Successfully deleted employee with id: {}", id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            log.warn("Employee with id {} not found for deletion", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
