package com.house58.terra.schedule.dto;

import com.house58.terra.contract.entity.Contract;
import com.house58.terra.schedule.enumm.SessionIdEnum;
import com.house58.terra.therapy.entity.Therapy;
import com.house58.terra.user.entity.Team;

import java.util.List;

public class DataTherapyPatienteDTO {

    private Contract contract;
    private Team team;
    private Therapy therapy;
    private List<SessionIdEnum> sessionList;



    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Therapy getTherapy() {
        return therapy;
    }

    public void setTherapy(Therapy therapy) {
        this.therapy = therapy;
    }

    public List<SessionIdEnum> getSessionList() {
        return sessionList;
    }

    public void setSessionList(List<SessionIdEnum> sessionList) {
        this.sessionList = sessionList;
    }
}
