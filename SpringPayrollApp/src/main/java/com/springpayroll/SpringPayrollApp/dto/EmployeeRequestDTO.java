package com.springpayroll.SpringPayrollApp.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class EmployeeRequestDTO {
    private Long id;
    private String name;
    private double salary;
}
