package com.house58.terra.schedule.entity;

import com.house58.terra.contract.entity.CarePlan;
import com.house58.terra.contract.entity.Contract;
import com.house58.terra.schedule.enumm.SessionIdEnum;
import com.house58.terra.user.entity.Discipline;
import jakarta.persistence.*;
import org.hibernate.boot.registry.selector.spi.StrategyCreator;

import java.util.Date;

//Agenda
@Entity
@Table(name = "shedule")
public class Shedule {
    @Id
    @GeneratedValue(strategy =  GenerationType.UUID)
    private Long id;
    private SessionIdEnum sessionIdEnum;
    private Discipline discipline;
    private Contract contract;
    private Date data;

    public Shedule() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
