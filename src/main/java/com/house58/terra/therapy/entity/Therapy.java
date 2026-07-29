package com.house58.terra.therapy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.house58.terra.schedule.entity.SShedule;
import com.house58.terra.schedule.entity.Session;
import com.house58.terra.user.entity.Team;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity(name = "therapy")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Therapy implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String description;
    private Boolean active;

    @ManyToMany(mappedBy = "therapies")
    @JsonIgnore
    private Set<Team> teams;


    @OneToMany
    private List<SShedule> sheduleList;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<SShedule> getSheduleList() {
        return sheduleList;
    }

    public void setSheduleList(List<SShedule> sheduleList) {
        this.sheduleList = sheduleList;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }
}
