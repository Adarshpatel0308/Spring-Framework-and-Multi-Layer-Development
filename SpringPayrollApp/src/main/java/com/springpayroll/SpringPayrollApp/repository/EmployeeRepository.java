package com.springpayroll.SpringPayrollApp.repository;

import com.springpayroll.SpringPayrollApp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
