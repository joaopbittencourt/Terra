package com.house58.terra.schedule.entity;

import com.house58.terra.contract.entity.Contract;
import com.house58.terra.schedule.enumm.SessionIdEnum;
import com.house58.terra.therapy.entity.Therapy;
import com.house58.terra.user.entity.Team;
import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity(name ="session")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Date date;
    @ManyToOne
    private Contract contract;
    private SessionIdEnum sessionId;
    @ManyToOne
    private Team team;
    @ManyToOne
    private Therapy therapy;
    private String exec;
    private Boolean status;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public SessionIdEnum getSessionId() {
        return sessionId;
    }

    public void setSessionId(SessionIdEnum sessionId) {
        this.sessionId = sessionId;
    }

    public Therapy getTherapy() {
        return therapy;
    }

    public void setTherapy(Therapy therapy) {
        this.therapy = therapy;
    }

    public String getExec() {
        return exec;
    }

    public void setExec(String exec) {
        this.exec = exec;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
