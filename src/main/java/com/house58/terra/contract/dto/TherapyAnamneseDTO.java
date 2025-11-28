package com.house58.terra.contract.dto;


import com.house58.terra.therapy.entity.Therapy;

import java.util.Date;

public class TherapyAnamneseDTO {
    private Therapy therapy;
    private Date data;


    public Therapy getTherapy() {
        return therapy;
    }

    public void setTherapy(Therapy therapy) {
        this.therapy = therapy;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
