package com.house58.terra.contract.dto;

import com.house58.terra.patient.entity.Responsible;

import java.util.Date;
import java.util.Set;

public class AnamnesisDTO {

    private Responsible responsible;
    private Date data;
    private Set<TherapyAnamneseDTO> therapyAnamneseDTO;
    private String description;

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

    public Set<TherapyAnamneseDTO> getTherapyAnamneseDTO() {
        return therapyAnamneseDTO;
    }

    public void setTherapyAnamneseDTO(Set<TherapyAnamneseDTO> therapyAnamneseDTO) {
        this.therapyAnamneseDTO = therapyAnamneseDTO;
    }
}
