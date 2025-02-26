package com.springpayroll.SpringPayrollApp.controller;


import com.springpayroll.SpringPayrollApp.dto.EmployeePayrollDTO;
import com.springpayroll.SpringPayrollApp.model.EmployeePayroll;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/employee")
    public class EmployeePayrollController {

        // POST endpoint to add an employee
        @PostMapping("/add")
        public String addEmployee(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
            // Convert DTO to Model
            EmployeePayroll employee = new EmployeePayroll();
            employee.setName(employeePayrollDTO.getName());
            employee.setSalary(employeePayrollDTO.getSalary());

            // Save to database (for now, just print)
            System.out.println("Employee added: " + employee);

            return "Employee added successfully!";
        }

        // GET endpoint to fetch an employee
        @GetMapping("/get")
        public EmployeePayrollDTO getEmployee() {
            // Simulate fetching data from the database
            EmployeePayrollDTO employeeDTO = new EmployeePayrollDTO();
            employeeDTO.setName("John Doe");
            employeeDTO.setSalary(50000.0);

            return employeeDTO; // Automatically converted to JSON
        }
    }
