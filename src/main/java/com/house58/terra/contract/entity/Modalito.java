package com.house58.terra.contract.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "modality")
public class Modalito {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;
    @Column(name = "modality")
    private String modality;


    public Modalito(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModality() {
        return modality;
    }

    public void setModality(String modality) {
        this.modality = modality;
    }

    public Boolean getStatus() {
        return true;
    }

    public void setStatus(Boolean status) {

    }
}
