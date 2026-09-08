package com.example.Service;

import org.springframework.stereotype.Service;

import com.example.DTO.ManagerRelationRequestDTO;
import com.example.Entity.Employee;
import com.example.Entity.ManagerRelation;
import com.example.Repository.EmployeeRepository;
import com.example.Repository.ManagerRelationRepository;

@Service
public class ManagerRelationService {

    private final ManagerRelationRepository managerRelationRepository;
    private final EmployeeRepository employeeRepository;

    public ManagerRelationService(
            ManagerRelationRepository managerRelationRepository,
            EmployeeRepository employeeRepository) {

        this.managerRelationRepository = managerRelationRepository;
        this.employeeRepository = employeeRepository;
    }

    public ManagerRelation createManagerRelation(
            ManagerRelationRequestDTO request) {

        Employee manager = employeeRepository
                .findById(request.getManagerId())
                .orElseThrow(() -> new RuntimeException("Manager not found"));

        Employee employee = employeeRepository
                .findById(request.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        ManagerRelation relation = new ManagerRelation();

        relation.setManager(manager);
        relation.setEmployee(employee);

        return managerRelationRepository.save(relation);
    }
}