package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.ManagerRelation;

public interface ManagerRelationRepository
        extends JpaRepository<ManagerRelation, Integer> {

}