package com.house58.terra.healthinsurance.dto;

import com.house58.terra.user.entity.Discipline;

public class DisciplineDTO {
    private Discipline discipline;
    private Double value;

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
