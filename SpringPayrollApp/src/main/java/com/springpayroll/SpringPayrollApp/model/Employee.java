package com.springpayroll.SpringPayrollApp.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data  //Using Lambok for getters and setters
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double salary;
}

