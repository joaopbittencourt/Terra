package com.house58.terra.schedule.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.house58.terra.contract.entity.Contract;
import com.house58.terra.schedule.enumm.SessionIdEnum;
import com.house58.terra.therapy.entity.Therapy;
import com.house58.terra.user.entity.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public record DataTherapyPatienteDTO(String therapist, String therapy, String sessionList ) {


    public String getTherapy() {
        return therapy;
    }

    public void setTherapy(String therapy) {
        therapy = therapy;
    }

    public String getTherapist() {
        return therapist;
    }

    public void setTherapist(String therapist) {
        therapist = therapist;
    }


    public List<String> getSessionArrayList() {
        return  new ArrayList<String>(Arrays.asList(sessionList.split(";")));
    }

}
