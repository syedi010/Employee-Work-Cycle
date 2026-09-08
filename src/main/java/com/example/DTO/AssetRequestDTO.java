package com.example.DTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;

@NoArgsConstructor 
@AllArgsConstructor 
@Getter
@Setter 
public class AssetRequestDTO {

    private String Laptop;
    private String Mobile;
    private String IdCard;
    private String Monitor;

    @NotNull(message="Employee Id cannot be null")
    private Integer employeeId;

}
