package com.house58.terra.schedule.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.house58.terra.contract.entity.Contract;
import com.house58.terra.schedule.enumm.SessionIdEnum;
import com.house58.terra.therapy.entity.Therapy;
import com.house58.terra.user.entity.Team;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Entity(name ="session")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Timestamp date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shedule_id")
    @JsonIgnore
    private SShedule shedule;
    private Boolean status;
    @Lob
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public SShedule getShedule() {
        return shedule;
    }

    public void setShedule(SShedule shedule) {
        this.shedule = shedule;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
