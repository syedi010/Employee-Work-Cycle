package com.example.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class BGV {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bgvId;

    @NotBlank
    private String sscCertificateNumber;
    @NotNull
    private Integer sscPassoutYear;
    @NotBlank
    private String hscCertificateNumber;
    private int hscPassoutYear;

    private String graduationCertificateNumber;
    private int graduationPassoutYear;

    private String status; // Pending, Verified, Rejected

    public BGV(String sscCertificateNumber, Integer sscPassoutYear, String hscCertificateNumber,
            int hscPassoutYear, String graduationCertificateNumber, int graduationPassoutYear, String status) {
  
        this.sscCertificateNumber = sscCertificateNumber;
        this.sscPassoutYear = sscPassoutYear;
        this.hscCertificateNumber = hscCertificateNumber;
        this.hscPassoutYear = hscPassoutYear;
        this.graduationCertificateNumber = graduationCertificateNumber;
        this.graduationPassoutYear = graduationPassoutYear;
        this.status = status;
    }

    // Getters and Setters



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
    public int getBgvId()
     { 
        return bgvId; 
    } 
    public void setBgvId(int bgvId) 
    { 
        this.bgvId = bgvId; 
    }
}
