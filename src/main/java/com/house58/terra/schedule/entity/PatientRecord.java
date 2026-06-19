package com.house58.terra.schedule.entity;

import com.house58.terra.patient.entity.Patient;
import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity(name ="patiente-record")
public class PatientRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Date data;
    @ManyToOne
    private SShedule shedule;
    @ManyToOne
    private Patient patient;
    private String description;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SShedule getShedule() {
        return shedule;
    }

    public void setShedule(SShedule shedule) {
        this.shedule = shedule;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

}
