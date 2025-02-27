package com.springpayroll.SpringPayrollApp.service;

import com.springpayroll.SpringPayrollApp.model.Employee;
import com.springpayroll.SpringPayrollApp.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;  // Import SLF4J annotation
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        log.info("Fetching all employees from the repository.");
        List<Employee> employees = employeeRepository.findAll();
        log.info("Successfully fetched {} employees.", employees.size());
        return employees;
    }

    public Optional<Employee> getEmployeeById(Long id) {
        log.info("Fetching employee with id: {}", id);
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            log.info("Employee with id {} found.", id);
        } else {
            log.warn("Employee with id {} not found.", id);
        }
        return employee;
    }

    public Employee createEmployee(Employee employee) {
        log.info("Creating new employee: {}", employee);
        Employee createdEmployee = employeeRepository.save(employee);
        log.info("Successfully created employee with id: {}", createdEmployee.getId());
        return createdEmployee;
    }

    public Employee updateEmployee(Long id, Employee employeeDetails) {
        log.info("Updating employee with id: {}", id);
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            Employee existingEmployee = employee.get();
            existingEmployee.setName(employeeDetails.getName());
            existingEmployee.setSalary(employeeDetails.getSalary());
            Employee updatedEmployee = employeeRepository.save(existingEmployee);
            log.info("Successfully updated employee with id: {}", id);
            return updatedEmployee;
        } else {
            log.warn("Employee with id {} not found for update.", id);
            return null;
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
            return false;
        }
    }
}
