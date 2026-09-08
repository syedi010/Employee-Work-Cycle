package com.example.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.DTO.EmployeeRequestDTO;
import com.example.Entity.BGV;
import com.example.Entity.Department;
import com.example.Entity.Employee;
import com.example.Entity.LeaveRequest;
import com.example.Entity.ManagerRelation;
import com.example.Entity.Salary;
import com.example.Exception.ResourceNotFoundException;
import com.example.Repository.EmployeeRepository;
import com.example.Repository.ManagerRelationRepository;

@Service
public class EmployeeService {

        private final EmployeeRepository employeeRepository;
        private final ManagerRelationRepository managerRelationRepository;

        public EmployeeService(
                        EmployeeRepository employeeRepository,
                        ManagerRelationRepository managerRelationRepository) {

                this.employeeRepository = employeeRepository;
                this.managerRelationRepository = managerRelationRepository;
        }

        // =========================================================
        // CREATE EMPLOYEE
        // =========================================================

        @Transactional
        public Employee createEmployee(EmployeeRequestDTO request) {

                if (request == null) {
                        return null;
                }

                // Create Employee Entity
                Employee employee = new Employee();

                employee.setEmp_name(request.getEmp_name());
                employee.setEmp_id(request.getEmp_id());
                employee.setAge(request.getAge());
                employee.setTitle(request.getTitle());
                employee.setOrganization(request.getOrganization());

                // =====================================================
                // BGV
                // =====================================================

                if (request.getBgvStatus() != null) {

                        BGV bgv = new BGV();

                        bgv.setSscCertificateNumber(
                                        request.getBgvStatus().getSscCertificateNumber());

                        bgv.setSscPassoutYear(
                                        request.getBgvStatus().getSscPassoutYear());

                        bgv.setHscCertificateNumber(
                                        request.getBgvStatus().getHscCertificateNumber());

                        bgv.setHscPassoutYear(
                                        request.getBgvStatus().getHscPassoutYear());

                        bgv.setGraduationCertificateNumber(
                                        request.getBgvStatus()
                                                        .getGraduationCertificateNumber());

                        bgv.setGraduationPassoutYear(
                                        request.getBgvStatus()
                                                        .getGraduationPassoutYear());

                        bgv.setStatus(
                                        request.getBgvStatus().getStatus());

                        employee.setBgvStatus(bgv);
                }

                // =====================================================
                // DEPARTMENT
                // =====================================================

                if (request.getDepartment() != null) {

                        Department department = new Department();

                        department.setDepartment(
                                        request.getDepartment().getDepartment());

                        employee.setDepartment(department);
                }

                // =====================================================
                // LEAVE REQUEST
                // =====================================================

                if (request.getLeaveRequest() != null) {

                        LeaveRequest leaveRequest = new LeaveRequest();

                        leaveRequest.setLeave(
                                        request.getLeaveRequest().getLeave());

                        employee.setLeaveRequest(leaveRequest);
                }

                // Save Salary

                if (request.getSalary() != null) {
                        Salary salary = new Salary();

                        salary.setPayment(request.getSalary().getPayment());

                        employee.setSalary(salary);
                }

                // =====================================================
                // SAVE EMPLOYEE
                // =====================================================

                Employee savedEmployee = employeeRepository.save(employee);

                // =====================================================
                // MANAGER RELATION
                // =====================================================

                if (request.getManagerRelation() != null) {

                        Integer managerId = request.getManagerRelation().getManagerId();

                        Employee manager = employeeRepository.findById(managerId)
                                        .orElseThrow(() -> new ResourceNotFoundException(
                                                        "Manager not found with ID: "
                                                                        + managerId));

                        ManagerRelation managerRelation = new ManagerRelation();

                        managerRelation.setManager(manager);

                        // The employee we just created
                        managerRelation.setEmployee(savedEmployee);

                        managerRelationRepository.save(managerRelation);
                }

                return savedEmployee;
        }

        // =========================================================
        // GET ALL EMPLOYEES
        // =========================================================

        public List<Employee> getAllEmployees() {

                return employeeRepository.findAll();
        }

        // =========================================================
        // GET EMPLOYEE BY ID
        // =========================================================

        public Employee getEmployeeById(Integer id) {

                return employeeRepository.findById(id)
                                .orElse(null);
        }

        // =========================================================
        // UPDATE EMPLOYEE
        // =========================================================

        @Transactional
        public Employee updateEmployee(
                        Integer id,
                        EmployeeRequestDTO request) {

                Employee employee = employeeRepository.findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException(
                                                "Employee not found with ID: "
                                                                + id));

                // -----------------------------------------------------
                // BASIC EMPLOYEE INFORMATION
                // -----------------------------------------------------

                employee.setEmp_name(request.getEmp_name());
                employee.setEmp_id(request.getEmp_id());
                employee.setAge(request.getAge());
                employee.setTitle(request.getTitle());
                employee.setOrganization(request.getOrganization());

                // -----------------------------------------------------
                // UPDATE BGV
                // -----------------------------------------------------

                if (request.getBgvStatus() != null) {

                        BGV bgv = employee.getBgvStatus();

                        if (bgv == null) {
                                bgv = new BGV();
                        }

                        bgv.setSscCertificateNumber(
                                        request.getBgvStatus()
                                                        .getSscCertificateNumber());

                        bgv.setSscPassoutYear(
                                        request.getBgvStatus()
                                                        .getSscPassoutYear());

                        bgv.setHscCertificateNumber(
                                        request.getBgvStatus()
                                                        .getHscCertificateNumber());

                        bgv.setHscPassoutYear(
                                        request.getBgvStatus()
                                                        .getHscPassoutYear());

                        bgv.setGraduationCertificateNumber(
                                        request.getBgvStatus()
                                                        .getGraduationCertificateNumber());

                        bgv.setGraduationPassoutYear(
                                        request.getBgvStatus()
                                                        .getGraduationPassoutYear());

                        bgv.setStatus(
                                        request.getBgvStatus()
                                                        .getStatus());

                        employee.setBgvStatus(bgv);
                }

                // -----------------------------------------------------
                // UPDATE DEPARTMENT
                // -----------------------------------------------------

                if (request.getDepartment() != null) {

                        Department department = employee.getDepartment();

                        if (department == null) {
                                department = new Department();
                        }

                        department.setDepartment(
                                        request.getDepartment()
                                                        .getDepartment());

                        employee.setDepartment(department);
                }

                // -----------------------------------------------------
                // UPDATE LEAVE REQUEST
                // -----------------------------------------------------

                if (request.getLeaveRequest() != null) {

                        LeaveRequest leaveRequest = employee.getLeaveRequest();

                        if (leaveRequest == null) {
                                leaveRequest = new LeaveRequest();
                        }

                        leaveRequest.setLeave(
                                        request.getLeaveRequest().getLeave());

                        employee.setLeaveRequest(leaveRequest);
                }

                // Update Salary

                if (request.getSalary() != null) {
                        Salary salary = new Salary();
                        salary.setPayment(request.getSalary().getPayment());

                        employee.setSalary(salary);
                }

                // -----------------------------------------------------
                // UPDATE MANAGER RELATION
                // -----------------------------------------------------

                if (request.getManagerRelation() != null) {

                        Integer managerId = request.getManagerRelation().getManagerId();

                        Employee manager = employeeRepository.findById(managerId)
                                        .orElseThrow(() -> new ResourceNotFoundException(
                                                        "Manager not found with ID: "
                                                                        + managerId));

                        ManagerRelation managerRelation = managerRelationRepository
                                        .findAll()
                                        .stream()
                                        .filter(relation -> relation.getEmployee() != null
                                                        && relation.getEmployee()
                                                                        .getID() == id)
                                        .findFirst()
                                        .orElseGet(ManagerRelation::new);

                        managerRelation.setManager(manager);
                        managerRelation.setEmployee(employee);

                        managerRelationRepository.save(managerRelation);
                }

                return employeeRepository.save(employee);
        }

        // =========================================================
        // DELETE EMPLOYEE
        // =========================================================

        @Transactional
        public void deleteEmployee(Integer id) {

                Employee employee = employeeRepository.findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException(
                                                "Employee not found with ID: "
                                                                + id));

                employeeRepository.delete(employee);
        }
}