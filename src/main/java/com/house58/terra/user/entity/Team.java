package com.house58.terra.user.entity;

import com.house58.terra.schedule.enumm.SessionIdEnum;
import com.house58.terra.user.enumm.BillingEnum;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String document;
    private String employDocument;
    private Date birthDay;
    private String organizationSocial;
    private BillingEnum billingMode;
    private String registry;
    @OneToMany
    private List<Discipline> discipline;
    private Set<SessionIdEnum> sessionsId;
    private String session;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getEmployDocument() {
        return employDocument;
    }

    public void setEmployDocument(String employDocument) {
        this.employDocument = employDocument;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getOrganizationSocial() {
        return organizationSocial;
    }

    public void setOrganizationSocial(String organizationSocial) {
        this.organizationSocial = organizationSocial;
    }

    public String getRegistry() {
        return registry;
    }

    public void setRegistry(String registry) {
        this.registry = registry;
    }

    public List<Discipline> getDiscipline() {
        return discipline;
    }

    public void setDiscipline(List<Discipline> discipline) {
        this.discipline = discipline;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public BillingEnum getBillingMode() {
        return billingMode;
    }

    public void setBillingMode(BillingEnum billingMode) {
        this.billingMode = billingMode;
    }

    public Set<SessionIdEnum> getSessionsId() {
        return sessionsId;
    }

    public void setSessionsId(Set<SessionIdEnum> sessionsId) {
        this.sessionsId = sessionsId;
    }
}
