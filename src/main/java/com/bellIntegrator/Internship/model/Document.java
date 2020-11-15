package com.bellIntegrator.Internship.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(indexes = {
        @Index(name = "IX_Document_Doc_Type_Id", columnList = "doc_type_id", unique = false) })
public class Document {

    @Id
    @Column(name = "id")
    private Long id;

    @Version
    private Integer version;

    @Column(name = "doc_number", length = 20, nullable = false)
    private String documentNumber;

    @Column(name = "doc_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate documentDate;

    @Column(name = "doc_type_id", nullable = false)
    private Long documentTypeId;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "document")
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id")
    private Document document;

    public Document() {
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

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public LocalDate getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(LocalDate documentDate) {
        this.documentDate = documentDate;
    }

    public Long getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(Long documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
