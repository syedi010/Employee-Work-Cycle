package com.example.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @NotBlank(message = "Employee name cannot be blank")
    @Size(max = 100, message = "Employee name cannot exceed 100 characters")
    private String emp_name;

    @NotBlank(message = "Employee ID cannot be blank")
    @Size(max = 50, message = "Employee ID cannot exceed 50 characters")
    private String emp_id;

    @NotNull(message = "Age cannot be null")
    @Min(value = 18, message = "Age should be at least 18")
    @Max(value = 65, message = "Age should not exceed 65")
    private Integer age;

    @NotBlank(message = "Title cannot be blank")
    private String title;

    @NotBlank(message = "Organization cannot be blank")
    @Size(max = 100, message = "Organization cannot exceed 100 characters")
    private String organization;

    public Employee(int iD, String emp_name, String emp_id, Integer age, String title, String organization,
            BGV bgvStatus, Department department, Salary salary, Attendance attendance, LeaveRequest leaveRequest) {
        ID = iD;
        this.emp_name = emp_name;
        this.emp_id = emp_id;
        this.age = age;
        this.title = title;
        this.organization = organization;
        this.bgvStatus = bgvStatus;
        this.department = department;
        this.salary = salary;
        this.attendance = attendance;
        this.leaveRequest = leaveRequest;

    }

    public Employee() {
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bgvId")
    private BGV bgvStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "salary_id")
    private Salary salary;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "attendance_id")
    private Attendance attendance;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "leave_request_id")
    private LeaveRequest leaveRequest;

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public BGV getBgvStatus() {
        return bgvStatus;
    }

    public void setBgvStatus(BGV bgvStatus) {
        this.bgvStatus = bgvStatus;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public LeaveRequest getLeaveRequest() {
        return leaveRequest;
    }

    public void setLeaveRequest(LeaveRequest leaveRequest) {
        this.leaveRequest = leaveRequest;
    }

}
