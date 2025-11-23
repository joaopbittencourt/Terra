package com.house58.terra.modality.entity;


import jakarta.persistence.*;

import java.util.UUID;

@Entity (name = "modality")
public class Modality {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "modality")
    private String modality;
    @Column(name = "description")
    private String description;

    @Column(name = "created")
    private String created;

    @Column(name = "updated")
    private String updated;



    public Modality(){

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }
}
