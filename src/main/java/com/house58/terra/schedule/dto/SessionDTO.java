package com.house58.terra.schedule.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.house58.terra.schedule.entity.SShedule;
import com.house58.terra.schedule.enumm.SessionIdEnum;
import com.house58.terra.therapy.entity.Therapy;
import com.house58.terra.user.entity.Team;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

public class SessionDTO implements Serializable {
    private UUID id;
    private SessionIdEnum sessionIdEnum;
    private Timestamp date;
    private Therapy therapy;
    private Team therapist;
    private Boolean status;
    private String description;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public SessionDTO(UUID id, SessionIdEnum sessionIdEnum, Timestamp date, Therapy therapy, Team therapist, Boolean status, String description, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.sessionIdEnum = sessionIdEnum;
        this.date = date;
        this.therapy = therapy;
        this.therapist = therapist;
        this.status = status;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public SessionIdEnum getSessionIdEnum() {
        return sessionIdEnum;
    }

    public void setSessionIdEnum(SessionIdEnum sessionIdEnum) {
        this.sessionIdEnum = sessionIdEnum;
    }

    public Therapy getTherapy() {
        return therapy;
    }

    public void setTherapy(Therapy therapy) {
        this.therapy = therapy;
    }

    public Team getTherapist() {
        return therapist;
    }

    public void setTherapist(Team therapist) {
        this.therapist = therapist;
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
