package com.bellIntegrator.Internship.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Citizenship {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "citizenship_code", nullable = false, unique = true)
    private Integer citizenshipCode;

    @Column(name = "citizenship_name", length = 60, nullable = false)
    private String citizenshipName;

    public Citizenship() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCitizenshipCode() {
        return citizenshipCode;
    }

    public void setCitizenshipCode(Integer citizenshipCode) {
        this.citizenshipCode = citizenshipCode;
    }

    public String getCitizenshipName() {
        return citizenshipName;
    }

    public void setCitizenshipName(String citizenshipName) {
        this.citizenshipName = citizenshipName;
    }
}
