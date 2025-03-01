package com.springpayroll.SpringPayrollApp.repository;

import com.springpayroll.SpringPayrollApp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Custom query to retrieve employees from the 'Sales' department
    @Query("SELECT e FROM Employee e WHERE e.department = 'Sales'")
    List<Employee> findEmployeesBySalesDepartment();
}
