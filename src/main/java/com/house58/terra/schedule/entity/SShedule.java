package com.house58.terra.schedule.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.house58.terra.contract.entity.Contract;
import com.house58.terra.schedule.enumm.SessionIdEnum;

import com.house58.terra.therapy.entity.Therapy;
import com.house58.terra.user.entity.Team;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

//Agenda
@Entity
@Table(name = "shedule")
public class SShedule {
    @Id
    @GeneratedValue(strategy =  GenerationType.UUID)
    private UUID id;
    private SessionIdEnum sessionIdEnum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "therapy_id")
    private Therapy therapy;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "therapist_id")
    private Team therapist;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_id")
    private Contract contract;

    @OneToMany(mappedBy = "shedule")
    @JsonIgnore
    private List<Session> sessionList;

    private Boolean isAnamnesis;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private Boolean status;

    public SShedule() {
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

    public Therapy getTherapy() {return therapy;}

    public void setTherapy(Therapy therapy) {this.therapy = therapy;}

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp data) {
        this.createdAt = data;
    }

    public Boolean getAnamnesis() {
        return isAnamnesis;
    }

    public void setAnamnesis(Boolean anamnesis) {
        isAnamnesis = anamnesis;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Team getTherapist() {
        return therapist;
    }

    public void setTherapist(Team therapist) {
        this.therapist = therapist;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Session> getSessionList() {
        return sessionList;
    }

    public void setSessionList(List<Session> sessionList) {
        this.sessionList = sessionList;
    }
}
