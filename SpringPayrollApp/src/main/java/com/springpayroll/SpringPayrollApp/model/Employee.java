package com.springpayroll.SpringPayrollApp.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor//Using Lambok for getters and setters
@Table(name = "employees")
public class Employee {
    @Id
    private Long id;
    private String name;
    private double salary;
}

