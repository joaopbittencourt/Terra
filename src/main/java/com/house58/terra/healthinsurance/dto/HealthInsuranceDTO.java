package com.house58.terra.healthinsurance.dto;

import com.house58.terra.healthinsurance.entity.HealthInsurance;

import java.util.List;

public class HealthInsuranceDTO {
    private HealthInsurance healthInsurance;
    private List<TherapyDTO> therapyDTOList;

    public HealthInsurance getHealthInsurance() {
        return healthInsurance;
    }

    public void setHealthInsurance(HealthInsurance healthInsurance) {
        this.healthInsurance = healthInsurance;
    }

    public List<TherapyDTO> getDisciplineDTOList() {
        return therapyDTOList;
    }

    public void setDisciplineDTOList(List<TherapyDTO> therapyDTOList) {
        this.therapyDTOList = therapyDTOList;
    }
}
