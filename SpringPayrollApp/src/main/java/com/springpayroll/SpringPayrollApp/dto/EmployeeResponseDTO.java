package com.springpayroll.SpringPayrollApp.dto;


import lombok.Data;

@Data // Lombok annotation for getters, setters, toString, etc.
public class EmployeeResponseDTO {

        private String name;
        private double salary;
    }

