package com.springpayroll.SpringPayrollApp.controller;

import com.springpayroll.SpringPayrollApp.dto.EmployeeRequestDTO;
import com.springpayroll.SpringPayrollApp.model.Employee;
import com.springpayroll.SpringPayrollApp.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<?> createEmployee(@Valid @RequestBody EmployeeRequestDTO employeeRequestDTO, BindingResult bindingResult) {
        log.info("Creating new employee: {}", employeeRequestDTO);

        if (bindingResult.hasErrors()) {
            // Return bad request if validation fails
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }

        // Convert DTO to Model
        Employee employee = new Employee();
        employee.setName(employeeRequestDTO.getName());
        employee.setSalary(employeeRequestDTO.getSalary());

        Employee createdEmployee = employeeService.createEmployee(employee);

        log.info("Successfully created employee with id: {}", createdEmployee.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeRequestDTO employeeRequestDTO, BindingResult bindingResult) {
        log.info("Updating employee with id: {}", id);

        if (bindingResult.hasErrors()) {
            // Return bad request if validation fails
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }

        Employee employeeDetails = new Employee();
        employeeDetails.setName(employeeRequestDTO.getName());
        employeeDetails.setSalary(employeeRequestDTO.getSalary());

        Employee updatedEmployee = employeeService.updateEmployee(id, employeeDetails);

        if (updatedEmployee != null) {
            log.info("Successfully updated employee with id: {}", id);
            return ResponseEntity.ok(updatedEmployee);
        } else {
            log.warn("Employee with id {} not found for update", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
