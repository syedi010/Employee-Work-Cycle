package com.example.DTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentRequestDTO {
    
    @NotBlank (message="Department cannot be blank")
    @Size(max=100, message="Maximum character for department is 100")
    private String department;


}
