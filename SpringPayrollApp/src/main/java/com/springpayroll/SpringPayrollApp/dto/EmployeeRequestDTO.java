package com.springpayroll.SpringPayrollApp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
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
    @Pattern(regexp = "^(Male|Female)$", message = "Gender must be either 'Male' or 'Female'")
    private String gender;

    @NotNull(message = "Start date cannot be null")
    @JsonFormat(pattern = "dd MMM yyyy")
    @PastOrPresent(message = "Start date must be in the past or present")
    private LocalDate startDate;

    @NotEmpty(message = "Note cannot be empty")
    private String note;

    @NotEmpty(message = "Profile picture cannot be empty")
    private String profilePic;

    @NotEmpty(message = "Department cannot be empty")
    private String department;
}
