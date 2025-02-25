package com.bridgelabz.EmployeePayrollApp.repository;

import com.bridgelabz.EmployeePayrollApp.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
