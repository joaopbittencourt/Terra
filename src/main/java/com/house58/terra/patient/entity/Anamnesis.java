package com.house58.terra.patient.entity;

import com.house58.terra.patient.enumm.StatusEnum;
import com.house58.terra.therapy.entity.Therapy;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity(name = "anamnesis")
public class Anamnesis {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    private Patient patient;
    private Date date;
    private String observation;
    @OneToMany
    private List<Therapy> therapy;
    private StatusEnum statusEnum;
    private BigDecimal value;

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

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Therapy> getTherapy() {return therapy;}

    public void setTherapy(List<Therapy> therapy) {this.therapy = therapy;}

    public StatusEnum getStatusEnum() {
        return statusEnum;
    }

    public void setStatusEnum(StatusEnum statusEnum) {
        this.statusEnum = statusEnum;
    }
}
