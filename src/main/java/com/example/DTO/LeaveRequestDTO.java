package com.example.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor

public class LeaveRequestDTO {
    
    @NotNull (message="Leave request cannot be null")
    private Double leave;
}
