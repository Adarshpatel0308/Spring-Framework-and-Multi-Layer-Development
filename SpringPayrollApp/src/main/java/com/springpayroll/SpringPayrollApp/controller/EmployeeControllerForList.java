package com.springpayroll.SpringPayrollApp.controller;

import com.springpayroll.SpringPayrollApp.dto.EmployeeResponseDTO;
import com.springpayroll.SpringPayrollApp.model.Employee;
import com.springpayroll.SpringPayrollApp.service.EmployeeServiceForList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@Slf4j // This annotation is used for apply logging
public class EmployeeControllerForList {

    @Autowired
    private EmployeeServiceForList employeePayrollService;

    // POST endpoint to add an employee
    @PostMapping("/add")
    public String addEmployee(@RequestBody EmployeeResponseDTO employeeResponseDTO) {
        // Convert DTO to Model
        Employee employee = new Employee();
        employee.setName(employeeResponseDTO.getName());
        employee.setSalary(employeeResponseDTO.getSalary());

        // Log the employee addition instead of printing to the console
        log.info("Employee added: {}", employee);

        return "Employee added successfully!";
    }

    // GET endpoint to fetch an employee
    @GetMapping("/get")
    public EmployeeResponseDTO getEmployee() {
        // Simulate fetching data from the database
        EmployeeResponseDTO employeeDTO = new EmployeeResponseDTO();
        employeeDTO.setName("John Doe");
        employeeDTO.setSalary(50000.0);

        log.info("Fetched employee: {}", employeeDTO);

        return employeeDTO;
    }

    // POST endpoint to add an employee
    @PostMapping("/add2")
    public ResponseEntity<String> addEmployee2(@RequestBody EmployeeResponseDTO employeeResponseDTO) {
        log.info("Received request to add employee: {}", employeeResponseDTO);

        String response = employeePayrollService.addEmployee(employeeResponseDTO);
        log.info("Employee added successfully: {}", employeeResponseDTO);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // GET endpoint to fetch all employees
    @GetMapping("/get2")
    public ResponseEntity<List<EmployeeResponseDTO>> getEmployees() {
        log.info("Fetching all employees...");

        List<EmployeeResponseDTO> employees = employeePayrollService.getEmployees();
        log.info("Fetched {} employees.", employees.size());

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
