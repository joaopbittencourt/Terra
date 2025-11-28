package com.house58.terra.contract.dto;

import com.house58.terra.patient.entity.Patient;
import com.house58.terra.therapy.entity.Therapy;

import java.util.List;

public class TherapyPatientDTO {
    private Patient patient;
    private Therapy therapies;
    private Integer amount;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Therapy getTherapies() {
        return therapies;
    }

    public void setTherapies(Therapy therapies) {
        this.therapies = therapies;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
