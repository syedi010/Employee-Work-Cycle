package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Salary;

public interface SalaryRepository extends JpaRepository<Salary, Integer> {

}