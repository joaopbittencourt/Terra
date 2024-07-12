package com.house58.terra.schedule.entity;

import com.house58.terra.contract.entity.Contract;
import com.house58.terra.schedule.enumm.SessionIdEnum;
import com.house58.terra.user.entity.Discipline;
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
    private Discipline discipline;
    @ManyToOne
    private Contract contract;
    private Date data;

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

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

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
}
