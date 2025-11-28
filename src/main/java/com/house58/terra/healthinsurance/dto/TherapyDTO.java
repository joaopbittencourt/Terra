package com.house58.terra.healthinsurance.dto;


import com.house58.terra.therapy.entity.Therapy;

public class TherapyDTO {
    private Therapy therapy;
    private Double value;

    public Therapy getTherapy() {
        return therapy;
    }

    public void setTherapy(Therapy therapy) {
        this.therapy = therapy;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
