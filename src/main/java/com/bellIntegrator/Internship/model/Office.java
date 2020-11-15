package com.bellIntegrator.Internship.model;

import javax.persistence.*;

@Entity
@Table(indexes = {
        @Index(name = "IX_Office_Org_Id", columnList = "id", unique = false) })
public class Office {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Version
    private Integer version;

    @Column(name = "office_name", length = 30, nullable = false)
    private String officeName;

    @Column(length = 255, nullable = false)
    private String address;

    @Column(length = 20, nullable = false)
    private String phone;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "org_id")
    private Organization organization;

    public Office() {
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

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
