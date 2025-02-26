package com.springpayroll.SpringPayrollApp.controller;


import com.springpayroll.SpringPayrollApp.dto.EmployeePayrollDTO;
import com.springpayroll.SpringPayrollApp.model.EmployeePayroll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.springpayroll.SpringPayrollApp.service.EmployeePayrollService;

//    @RestController
//    @RequestMapping("/employee")
//    public class EmployeePayrollController {
//
//        // POST endpoint to add an employee
//        @PostMapping("/add")
//        public String addEmployee(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
//            // Convert DTO to Model
//            EmployeePayroll employee = new EmployeePayroll();
//            employee.setName(employeePayrollDTO.getName());
//            employee.setSalary(employeePayrollDTO.getSalary());
//
//            // Save to database (for now, just print)
//            System.out.println("Employee added: " + employee);
//
//            return "Employee added successfully!";
//        }
//
//        // GET endpoint to fetch an employee
//        @GetMapping("/get")
//        public EmployeePayrollDTO getEmployee() {
//            // Simulate fetching data from the database
//            EmployeePayrollDTO employeeDTO = new EmployeePayrollDTO();
//            employeeDTO.setName("John Doe");
//            employeeDTO.setSalary(50000.0);
//
//            return employeeDTO; // Automatically converted to JSON
//        }
//    }

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService employeePayrollService;

    // POST endpoint to add an employee
    @PostMapping("/add")
    public ResponseEntity<String> addEmployee(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
        String response = employeePayrollService.addEmployee(employeePayrollDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED); // HTTP 201 status
    }

    // GET endpoint to fetch all employees
    @GetMapping("/get")
    public ResponseEntity<List<EmployeePayrollDTO>> getEmployees() {
        List<EmployeePayrollDTO> employees = employeePayrollService.getEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK); // HTTP 200 status
    }
}


//In UC3 we have to connect this with the DATABASE that we are already done.....in UC2
