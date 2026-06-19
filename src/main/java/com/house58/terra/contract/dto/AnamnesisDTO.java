package com.house58.terra.contract.dto;

import com.house58.terra.contract.entity.Contract;
import com.house58.terra.patient.entity.Guardians;
import com.house58.terra.patient.entity.Patient;

import java.util.Date;
import java.util.Set;

public class AnamnesisDTO {

    private Date data;
    private Set<TherapyAnamneseDTO> therapyAnamneseDTO;
    private String description;
    private Contract contract;

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

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
