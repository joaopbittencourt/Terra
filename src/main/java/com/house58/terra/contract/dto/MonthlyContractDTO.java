package com.house58.terra.contract.dto;

import java.math.BigDecimal;

public class MonthlyContractDTO {
    private BigDecimal monthlyValue;
    private Integer billingDay;

    public BigDecimal getMonthlyValue() {
        return monthlyValue;
    }

    public void setMonthlyValue(BigDecimal monthlyValue) {
        this.monthlyValue = monthlyValue;
    }

    public Integer getBillingDay() {
        return billingDay;
    }

    public void setBillingDay(Integer billingDay) {
        this.billingDay = billingDay;
    }
}
