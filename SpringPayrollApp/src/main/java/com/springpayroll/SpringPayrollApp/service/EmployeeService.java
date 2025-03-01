package com.springpayroll.SpringPayrollApp.service;

import com.springpayroll.SpringPayrollApp.dto.EmployeeRequestDTO;
import com.springpayroll.SpringPayrollApp.exception.EmployeeNotFoundException;
import com.springpayroll.SpringPayrollApp.model.Employee;
import com.springpayroll.SpringPayrollApp.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j  // Logging added here
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        log.info("Fetching all employees from the repository.");
        List<Employee> employees = employeeRepository.findAll();
        log.info("Successfully fetched {} employees.", employees.size());
        return employees;
    }

    public Employee getEmployeeById(Long id) {
        log.info("Fetching employee with id: {}", id);
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            log.info("Employee with id {} found.", id);
            return employee.get();
        } else {
            log.warn("Employee with id {} not found.", id);
            throw new EmployeeNotFoundException("Employee with id " + id + " not found.");
        }
    }

    public Employee createEmployee(EmployeeRequestDTO employeeDTO) {
        log.info("Creating new employee with details: {}", employeeDTO);
        Employee employee = mapToEntity(employeeDTO);
        Employee createdEmployee = employeeRepository.save(employee);
        log.info("Successfully created employee with id: {}", createdEmployee.getId());
        return createdEmployee;
    }

    public Employee updateEmployee(Long id, EmployeeRequestDTO employeeDTO) {
        log.info("Updating employee with id: {}", id);
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            Employee updatedEmployee = mapToEntity(employeeDTO);
            updatedEmployee.setId(id); // Ensure the ID is not overwritten
            updatedEmployee = employeeRepository.save(updatedEmployee);
            log.info("Successfully updated employee with id: {}", id);
            return updatedEmployee;
        } else {
            log.warn("Employee with id {} not found for update.", id);
            throw new EmployeeNotFoundException("Employee with id " + id + " not found for update.");
        }
    }

    public boolean deleteEmployee(Long id) {
        log.info("Attempting to delete employee with id: {}", id);
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            log.info("Successfully deleted employee with id: {}", id);
            return true;
        } else {
            log.warn("Employee with id {} not found for deletion.", id);
            throw new EmployeeNotFoundException("Employee with id " + id + " not found for deletion.");
        }
    }

    private Employee mapToEntity(EmployeeRequestDTO dto) {
        Employee employee = new Employee();
        employee.setId(dto.getId());
        employee.setName(dto.getName());
        employee.setSalary(dto.getSalary());
        employee.setGender(dto.getGender());
        employee.setStartDate(dto.getStartDate());
        employee.setNote(dto.getNote());
        employee.setProfilePic(dto.getProfilePic());
        employee.setDepartment(dto.getDepartment());
        return employee;
    }
}
//In the UC4 of Section-5 of Employee Payroll the database is already installed
//In the UC5 of Section-5 of Employee Payroll the rest API's are already created 