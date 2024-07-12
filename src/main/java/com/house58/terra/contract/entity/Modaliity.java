package com.house58.terra.contract.entity;


import jakarta.persistence.*;

import java.util.UUID;

@Entity (name = "modality")
public class Modaliity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "modality")
    private String modality;


    public Modaliity(){

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
