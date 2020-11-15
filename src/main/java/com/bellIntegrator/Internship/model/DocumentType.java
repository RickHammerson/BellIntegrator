package com.bellIntegrator.Internship.model;

import javax.persistence.*;

@Entity
@Table(name = "Doc_Type")
public class DocumentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "doc_code", nullable = false, unique = true)
    private Long documentCode;

    @Column(name = "doc_name", length = 150, nullable = false)
    private String documentName;

    public DocumentType() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDocumentCode() {
        return documentCode;
    }

    public void setDocumentCode(Long documentCode) {
        this.documentCode = documentCode;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }
}
