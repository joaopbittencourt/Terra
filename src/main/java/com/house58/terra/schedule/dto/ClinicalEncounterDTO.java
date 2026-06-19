package com.house58.terra.schedule.dto;

import com.house58.terra.schedule.enumm.SessionIdEnum;

import java.sql.Timestamp;

public record ClinicalEncounterDTO(String sscheduleId, String description, Timestamp date) {
    @Override
    public String sscheduleId() {
        return sscheduleId;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public Timestamp date() {
        return date;
    }



}
