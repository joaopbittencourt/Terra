package com.house58.terra.schedule.dto;

import com.house58.terra.schedule.enumm.SessionIdEnum;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class ScheduleDTO implements Serializable {
    private UUID therapistId;
    private UUID therapyId;
    private List<SessionIdEnum> sessionIdEnumList;

    public UUID getTherapistId() {
        return therapistId;
    }

    public void setTherapistId(UUID therapistId) {
        this.therapistId = therapistId;
    }

    public UUID getTherapyId() {
        return therapyId;
    }

    public void setTherapyId(UUID therapyId) {
        this.therapyId = therapyId;
    }

    public List<SessionIdEnum> getSessionIdEnumList() {
        return sessionIdEnumList;
    }

    public void setSessionIdEnumList(List<SessionIdEnum> sessionIdEnumList) {
        this.sessionIdEnumList = sessionIdEnumList;
    }
}
