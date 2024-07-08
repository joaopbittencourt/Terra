package com.house58.terra.patient.entity;

import com.house58.terra.schedule.enumm.SessionIdEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.Set;

@Entity(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private long id;
    private String name;
    private Date birthDay;
    private String document;
    private Boolean status;
    private Set<SessionIdEnum> sessionsId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Set<SessionIdEnum> getSessionsId() {
        return sessionsId;
    }

    public void setSessionsId(Set<SessionIdEnum> sessionsId) {
        this.sessionsId = sessionsId;
    }
}
