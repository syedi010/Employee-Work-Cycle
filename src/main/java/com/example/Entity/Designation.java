package com.example.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Designation {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String SoftwareEngineer;
    private String SeniorDeveloper;
    private String FunctionalAnalyst;
    private String TeamLead;
    private String Manager;
    private String TechLead;
    private String CEO;
    private String GroupHead;
    private String VerticalHead;

    @ManyToOne
    @JoinColumn (name="employee_id")
    private Employee employee;
}
