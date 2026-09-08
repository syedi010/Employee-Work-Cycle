package com.example.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Attendance {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int attendance_id;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

    @NotNull(message="Attendance Date cannot be null")
    private LocalDate attendanceDate;

    @NotNull(message="Status message cannot be null")
    private String status;



}
