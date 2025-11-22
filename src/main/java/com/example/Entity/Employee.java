package com.example.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    private String emp_name;

    private String emp_id;

    private String age;

    private String title;

    private String organization;

    public Employee(int iD, String emp_name, String emp_id, String age, String title, String organization,
            BGV bgvStatus) {
        ID = iD;
        this.emp_name = emp_name;
        this.emp_id = emp_id;
        this.age = age;
        this.title = title;
        this.organization = organization;
        this.bgvStatus = bgvStatus;
    }

    public Employee() {
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bgv_id")
    private BGV bgvStatus;

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

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
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

}
