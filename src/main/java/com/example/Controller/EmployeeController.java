package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Employee;
import com.example.Service.EmployeeService;

@RestController

@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/createEmployee")

    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {

        Employee updatedEmployee = employeeService.creatEmployee(employee);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedEmployee);
    }

    @PostMapping("/fetchAllEmployee")

    public ResponseEntity<List<Employee>> fetchAllEmployee() {
        List<Employee> list = employeeService.getAllEmployees();

        return ResponseEntity.ok(list);
    }

}
