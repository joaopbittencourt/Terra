package com.house58.terra.patient.entity;

import jakarta.persistence.*;

@Entity(name = "responsavel")
public class Responsible {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private long id;

    private String name;

    private String document;

    private Long documentFis;

    private String phone;

    private Boolean status;

    @ManyToOne
    private Patient patient;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Long getDocumentFis() {
        return documentFis;
    }

    public void setDocumentFis(Long documentFis) {
        this.documentFis = documentFis;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
