package com.house58.terra.healthinsurance.service;

import com.house58.terra.finance.dao.CostRepository;
import com.house58.terra.finance.entity.Cost;
import com.house58.terra.healthinsurance.dao.HealthInsuranceRepository;
import com.house58.terra.healthinsurance.dto.TherapyDTO;
import com.house58.terra.healthinsurance.dto.HealthInsuranceDTO;
import com.house58.terra.healthinsurance.entity.HealthInsurance;
import org.springframework.stereotype.Service;

@Service
public class RegisterHealthInsurance {

    private HealthInsuranceRepository healthInsuranceRepository;
    private CostRepository costRepository;

    public RegisterHealthInsurance(HealthInsuranceRepository healthInsuranceRepository, CostRepository costRepository) {
        this.healthInsuranceRepository = healthInsuranceRepository;
        this.costRepository = costRepository;
    }

    public HealthInsurance register(HealthInsuranceDTO healthInsuranceDTO){
        try {
            HealthInsurance healthInsurance = this.healthInsuranceRepository.save(healthInsuranceDTO.getHealthInsurance());

            for(TherapyDTO therapyDTO : healthInsuranceDTO.getDisciplineDTOList()){
                Cost cost = new Cost();
                cost.setHealthInsurance(healthInsuranceDTO.getHealthInsurance());
                cost.setTherapy(therapyDTO.getTherapy());
                cost.setValue(therapyDTO.getValue());
                this.costRepository.save(cost);
            }
            return healthInsurance;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
