package com.example.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor 
@Getter
@Setter
@AllArgsConstructor 
public class ManagerRelationRequestDTO {
    
    @NotNull (message="Manager Id cannot be null")
    private Integer managerId;

    @NotNull (message="Employee Id cannot be null")
    private Integer employeeId;
}
