package com.example.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;

@Entity
public class BGV {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Employee reference
    @OneToOne(mappedBy = "bgvStatus")

    private Employee employee;

    private String sscCertificateNumber;
    private int sscPassoutYear;

    private String hscCertificateNumber;
    private int hscPassoutYear;

    private String graduationCertificateNumber;
    private int graduationPassoutYear;

    private String status; // Pending, Verified, Rejected

    public BGV(int id, Employee employee, String sscCertificateNumber, int sscPassoutYear, String hscCertificateNumber,
            int hscPassoutYear, String graduationCertificateNumber, int graduationPassoutYear, String status) {
        this.id = id;
        this.employee = employee;
        this.sscCertificateNumber = sscCertificateNumber;
        this.sscPassoutYear = sscPassoutYear;
        this.hscCertificateNumber = hscCertificateNumber;
        this.hscPassoutYear = hscPassoutYear;
        this.graduationCertificateNumber = graduationCertificateNumber;
        this.graduationPassoutYear = graduationPassoutYear;
        this.status = status;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getSscCertificateNumber() {
        return sscCertificateNumber;
    }

    public BGV() {
    }

    public void setSscCertificateNumber(String sscCertificateNumber) {
        this.sscCertificateNumber = sscCertificateNumber;
    }

    public int getSscPassoutYear() {
        return sscPassoutYear;
    }

    public void setSscPassoutYear(int sscPassoutYear) {
        this.sscPassoutYear = sscPassoutYear;
    }

    public String getHscCertificateNumber() {
        return hscCertificateNumber;
    }

    public void setHscCertificateNumber(String hscCertificateNumber) {
        this.hscCertificateNumber = hscCertificateNumber;
    }

    public int getHscPassoutYear() {
        return hscPassoutYear;
    }

    public void setHscPassoutYear(int hscPassoutYear) {
        this.hscPassoutYear = hscPassoutYear;
    }

    public String getGraduationCertificateNumber() {
        return graduationCertificateNumber;
    }

    public void setGraduationCertificateNumber(String graduationCertificateNumber) {
        this.graduationCertificateNumber = graduationCertificateNumber;
    }

    public int getGraduationPassoutYear() {
        return graduationPassoutYear;
    }

    public void setGraduationPassoutYear(int graduationPassoutYear) {
        this.graduationPassoutYear = graduationPassoutYear;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
