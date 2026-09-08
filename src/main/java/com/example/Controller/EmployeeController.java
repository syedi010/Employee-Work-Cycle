package com.example.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.EmployeeRequestDTO;
import com.example.Entity.Employee;
import com.example.Service.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Create Employee
    @PostMapping("/createEmployee")
    public ResponseEntity<Employee> addEmployee(
            @Valid @RequestBody EmployeeRequestDTO employeeRequest) {

        Employee savedEmployee =
                employeeService.createEmployee(employeeRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedEmployee);
    }

    // Fetch All Employees
    @GetMapping("/fetchAllEmployee")
    public ResponseEntity<List<Employee>> fetchAllEmployee() {

        List<Employee> employees =
                employeeService.getAllEmployees();

        return ResponseEntity.ok(employees);
    }

    // Fetch Employee By ID
    @GetMapping("/fetchEmployeeById/{id}")
    public ResponseEntity<Employee> fetchEmployeeById(
            @PathVariable Integer id) {

        Employee employee =
                employeeService.getEmployeeById(id);

        if (employee == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(employee);
    }

    // Update Employee
    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable Integer id,
            @Valid @RequestBody EmployeeRequestDTO employeeRequest) {

        Employee updatedEmployee =
                employeeService.updateEmployee(id, employeeRequest);

        return ResponseEntity.ok(updatedEmployee);
    }

    // Delete Employee
    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<String> deleteEmployee(
            @PathVariable Integer id) {

        employeeService.deleteEmployee(id);

        return ResponseEntity.ok(
                "Employee Deleted Successfully"
        );
    }
}