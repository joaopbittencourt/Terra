package com.house58.terra.contract.dto;

import java.util.UUID;

public class HealthPlanDTO {
    private UUID planCode;

    public UUID getPlanCode() {
        return planCode;
    }

    public void setPlanCode(UUID planCode) {
        this.planCode = planCode;
    }
}
