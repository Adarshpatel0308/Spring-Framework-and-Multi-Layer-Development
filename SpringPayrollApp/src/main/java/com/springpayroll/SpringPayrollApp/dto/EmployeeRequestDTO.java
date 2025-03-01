package com.springpayroll.SpringPayrollApp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class EmployeeRequestDTO {

    private Long id;

    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Za-z\\s]+$", message = "Name can only contain letters and spaces")
    private String name;

    private double salary;

    @NotEmpty(message = "Gender cannot be empty")
    private String gender;  // New field

    private LocalDate startDate;

    private String note;

    private String profilePic;

    private String department;
}
