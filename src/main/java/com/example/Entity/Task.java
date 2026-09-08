package com.example.Entity;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Task {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int task_id;

    @NotBlank(message="Task name cannot be empty")
    private String taskName;

    @Size(max=2000, message="Description cannot exceed 2000 characters")
    private String description;
    
    private LocalDate startDate;

    private String status;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;
    
}
