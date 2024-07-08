package com.house58.terra.contract.dto;

import com.house58.terra.user.entity.Discipline;

import java.util.Date;

public class DisciplineAnamneseDTO {
    private Discipline discipline;
    private Date data;


    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
