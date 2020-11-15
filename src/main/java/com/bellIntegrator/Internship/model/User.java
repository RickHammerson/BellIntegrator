package com.bellIntegrator.Internship.model;

import javax.persistence.*;

@Entity
@Table(indexes = {
        @Index(name = "IX_User_Office_Id", columnList = "office_id", unique = false),
        @Index(name = "IX_User_Citizenship_Id", columnList = "citizenship_id", unique = false) })
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Version
    private Integer version;

    @Column(name = "first_name", length = 30, nullable = false)
    private String firstName;

    @Column(name = "middle_name", length = 30, nullable = false)
    private String middleName;

    @Column(name = "second_name", length = 30, nullable = false)
    private String secondName;

    @Column(name = "position_in_company", length = 40, nullable = false)
    private String positionInCompany;

    @Column(length = 20, nullable = false)
    private String phone;

    @Column(name = "is_identified", nullable = false)
    private boolean isIdentified;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "office_id",nullable = false)
    private Office office;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "citizenship_id",nullable = false)
    private Citizenship citizenship;

    @OneToOne(mappedBy = "user",fetch = FetchType.LAZY)
    private Document document;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPositionInCompany() {
        return positionInCompany;
    }

    public void setPositionInCompany(String positionInCompany) {
        this.positionInCompany = positionInCompany;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isIdentified() {
        return isIdentified;
    }

    public void setIdentified(boolean identified) {
        isIdentified = identified;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Citizenship getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(Citizenship citizenship) {
        this.citizenship = citizenship;
    }
}
