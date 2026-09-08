package com.example.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.ManagerRelationRequestDTO;
import com.example.Entity.ManagerRelation;
import com.example.Service.ManagerRelationService;

import jakarta.validation.Valid;

@RestController
public class ManagerRelationController {

    private final ManagerRelationService managerRelationService;

    public ManagerRelationController(ManagerRelationService managerRelationService) {
        this.managerRelationService = managerRelationService;
    }

    @PostMapping("/createManagerRelation")
    public ResponseEntity<ManagerRelation> createManagerRelation(
            @Valid @RequestBody ManagerRelationRequestDTO request) {

        ManagerRelation relation = managerRelationService.createManagerRelation(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(relation);
    }
}