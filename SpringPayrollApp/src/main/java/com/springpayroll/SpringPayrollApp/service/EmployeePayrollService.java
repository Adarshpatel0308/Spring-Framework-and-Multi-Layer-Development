package com.springpayroll.SpringPayrollApp.service;

import com.springpayroll.SpringPayrollApp.dto.EmployeePayrollDTO;
import com.springpayroll.SpringPayrollApp.model.EmployeePayroll;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService {

    private List<EmployeePayroll> employeeList = new ArrayList<>();

    public String addEmployee(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayroll employee = new EmployeePayroll();
        employee.setName(employeePayrollDTO.getName());
        employee.setSalary(employeePayrollDTO.getSalary());
        employeeList.add(employee);
        return "Employee added successfully!";
    }

    public List<EmployeePayrollDTO> getEmployees() {
        List<EmployeePayrollDTO> employeeDTOList = new ArrayList<>();
        for (EmployeePayroll employee : employeeList) {
            EmployeePayrollDTO employeeDTO = new EmployeePayrollDTO();
            employeeDTO.setName(employee.getName());
            employeeDTO.setSalary(employee.getSalary());
            employeeDTOList.add(employeeDTO);
        }
        return employeeDTOList;
    }
}
