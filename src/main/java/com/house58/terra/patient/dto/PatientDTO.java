package com.house58.terra.patient.dto;

import com.house58.terra.contract.entity.Contract;
import com.house58.terra.patient.entity.Anamnesis;
import com.house58.terra.patient.entity.Patient;

public class PatientDTO {

    private Patient patient;
    private Contract contract;
    private Anamnesis anamnesis;

    public PatientDTO() {

    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Anamnesis getAnamnesis() {
        return anamnesis;
    }

    public void setAnamnesis(Anamnesis anamnesis) {
        this.anamnesis = anamnesis;
    }
}
