package com.example.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class SalaryRequestDTO {

    @NotNull(message = "Payment must not be null")
    @Positive(message = "Payment must be greater than zero")
    private double payment;
}
