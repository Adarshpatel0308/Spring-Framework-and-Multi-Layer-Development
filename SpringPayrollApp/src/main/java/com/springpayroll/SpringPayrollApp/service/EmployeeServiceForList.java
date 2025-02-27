package com.springpayroll.SpringPayrollApp.service;

import com.springpayroll.SpringPayrollApp.dto.EmployeeResponseDTO;
import com.springpayroll.SpringPayrollApp.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceForList {

    private List<Employee> employeeList = new ArrayList<>();

    public String addEmployee(EmployeeResponseDTO employeeResponseDTO) {
        Employee employee = new Employee();
        employee.setName(employeeResponseDTO.getName());
        employee.setSalary(employeeResponseDTO.getSalary());
        employeeList.add(employee);
        return "Employee added successfully!";
    }

    public List<EmployeeResponseDTO> getEmployees() {
        List<EmployeeResponseDTO> employeeDTOList = new ArrayList<>();
        for (Employee employee : employeeList) {
            EmployeeResponseDTO employeeDTO = new EmployeeResponseDTO();
            employeeDTO.setName(employee.getName());
            employeeDTO.setSalary(employee.getSalary());
            employeeDTOList.add(employeeDTO);
        }
        return employeeDTOList;
    }
}
