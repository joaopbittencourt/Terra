package com.house58.terra.contract.dto;


import com.house58.terra.therapy.entity.Therapy;
import com.house58.terra.user.entity.Team;

import java.sql.Timestamp;
import java.util.Date;

public class TherapyAnamneseDTO {
    private Therapy therapy;
    private Team therapist;
    private Timestamp data;


    public Therapy getTherapy() {
        return therapy;
    }

    public void setTherapy(Therapy therapy) {
        this.therapy = therapy;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public Team getTherapist() {
        return therapist;
    }

    public void setTherapist(Team therapist) {
        this.therapist = therapist;
    }
}
