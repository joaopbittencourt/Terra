package com.house58.terra.healthinsurance.dto;

import com.house58.terra.healthinsurance.entity.HealthInsurance;
import com.house58.terra.user.entity.Discipline;

import java.util.List;

public class HealthInsuranceDTO {
    private HealthInsurance healthInsurance;
    private List<DisciplineDTO> disciplineDTOList;

    public HealthInsurance getHealthInsurance() {
        return healthInsurance;
    }

    public void setHealthInsurance(HealthInsurance healthInsurance) {
        this.healthInsurance = healthInsurance;
    }

    public List<DisciplineDTO> getDisciplineDTOList() {
        return disciplineDTOList;
    }

    public void setDisciplineDTOList(List<DisciplineDTO> disciplineDTOList) {
        this.disciplineDTOList = disciplineDTOList;
    }
}
