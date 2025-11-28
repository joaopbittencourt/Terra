package com.house58.terra.schedule.entity;

import com.house58.terra.contract.entity.Contract;
import com.house58.terra.schedule.enumm.SessionIdEnum;

import com.house58.terra.therapy.entity.Therapy;
import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

//Agenda
@Entity(name = "shedule")
public class Shedule {
    @Id
    @GeneratedValue(strategy =  GenerationType.UUID)
    private UUID id;
    private SessionIdEnum sessionIdEnum;
    @ManyToOne
    private Therapy therapy;
    @ManyToOne
    private Contract contract;

    private Boolean isAnamnesis;

    private Date data;

    private Boolean status;

    public Shedule() {
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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
}
