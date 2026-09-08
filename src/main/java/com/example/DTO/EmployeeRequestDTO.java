package com.example.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestDTO {

    @NotBlank(message = "Employee name cannot be blank")
    @Size(max = 100, message = "Employee name cannot exceed 100 characters")
    private String emp_name;

    @NotBlank(message = "Employee ID cannot be blank")
    @Size(max = 50, message = "Employee ID cannot exceed 50 characters")
    private String emp_id;

    @NotNull(message = "Age cannot be null")
    @Min(value = 18, message = "Age should be at least 18")
    @Max(value = 65, message = "Age should not exceed 65")
    private Integer age;

    @NotBlank(message = "Title cannot be blank")
    private String title;

    @NotBlank(message = "Organization cannot be blank")
    @Size(max = 100, message = "Organization cannot exceed 100 characters")
    private String organization;

    @Valid
    private BGVRequestDTO bgvStatus;

    @Valid
    private DepartmentRequestDTO department;

    @Valid
    private LeaveRequestDTO leaveRequest;

    @Valid
    private ManagerRelationRequestDTO managerRelation;

    @Valid
    private SalaryRequestDTO salary;

}