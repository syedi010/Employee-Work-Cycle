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

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor 
public class ManagerRelation{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int relationId;

    @ManyToOne
    @JoinColumn (name="manager_id")
    private Employee manager;

    @ManyToOne
    @JoinColumn (name="employee_id")
    private Employee employee;



}