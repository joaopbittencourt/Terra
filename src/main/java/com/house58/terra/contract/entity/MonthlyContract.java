package com.house58.terra.contract.entity;

import com.house58.terra.contract.enumm.ContractStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.UUID;
@Entity
@Table(name = "monthly_contracts")
public class MonthlyContract {

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;

        @OneToOne
        private Contract contract;

        private Integer weeklyFrequency; // 1x, 2x, 3x na semana

        private BigDecimal monthlyValue; // Valor fixo acordado

        private Integer billingDay; // Dia do vencimento

        private Timestamp startDate;
        private Timestamp endDate; // Opcional (até quando o contrato vale)

        @Enumerated(EnumType.STRING)
        private ContractStatus status; // ACTIVE, SUSPENDED, CANCELLED
/*
        public boolean isActive() {
            return status == ContractStatus.ACTIVE &&
                    (endDate == null || !LocalDate.now().isAfter(endDate.getTime()));
        }
*/
        public UUID getId() {
            return id;
        }

        public void setId(UUID id) {
            this.id = id;
        }

        public Contract getContract() {
            return contract;
        }

        public void setContract(Contract contract) {
            this.contract = contract;
        }

        public Integer getWeeklyFrequency() {
            return weeklyFrequency;
        }

        public void setWeeklyFrequency(Integer weeklyFrequency) {
            this.weeklyFrequency = weeklyFrequency;
        }

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

        public Timestamp getStartDate() {
            return startDate;
        }

        public void setStartDate(Timestamp startDate) {
            this.startDate = startDate;
        }

        public Timestamp getEndDate() {
            return endDate;
        }

        public void setEndDate(Timestamp endDate) {
            this.endDate = endDate;
        }

        public ContractStatus getStatus() {
            return status;
        }

        public void setStatus(ContractStatus status) {
            this.status = status;
        }
}

