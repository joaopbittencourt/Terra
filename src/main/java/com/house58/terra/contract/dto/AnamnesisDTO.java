package com.house58.terra.contract.dto;

import com.house58.terra.patient.entity.Patient;
import com.house58.terra.patient.entity.Responsible;
import com.house58.terra.schedule.enumm.SessionIdEnum;
import com.house58.terra.user.entity.Discipline;

import java.util.Date;
import java.util.Set;

public class AnamnesisDTO {
    private Patient patient;
    private Responsible responsible;
    private Date data;
    private Set<DisciplineAnamneseDTO> disciplineAnamneseDTO;
    private String description;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Responsible getResponsible() {
        return responsible;
    }

    public void setResponsible(Responsible responsible) {
        this.responsible = responsible;
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

    public Set<DisciplineAnamneseDTO> getDisciplineAnamneseDTO() {
        return disciplineAnamneseDTO;
    }

    public void setDisciplineAnamneseDTO(Set<DisciplineAnamneseDTO> disciplineAnamneseDTO) {
        this.disciplineAnamneseDTO = disciplineAnamneseDTO;
    }
}
