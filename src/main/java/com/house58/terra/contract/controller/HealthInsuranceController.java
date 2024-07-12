package com.house58.terra.contract.controller;

import com.house58.terra.contract.dao.HealthInsuranceRepository;
import com.house58.terra.contract.entity.HealthInsurance;
import org.springframework.web.bind.annotation.*;

@RestController 
@RequestMapping("/healthinsurance")
public class HealthInsuranceController {
    private final HealthInsuranceRepository healthInsuranceRepository ;

    public HealthInsuranceController(HealthInsuranceRepository healthInsuranceRepository) {
        this.healthInsuranceRepository = healthInsuranceRepository;
    }
    @PostMapping("/save-healthinsurance")
    private HealthInsurance save(@RequestBody HealthInsurance healthInsurance){
        return this.healthInsuranceRepository.save(healthInsurance);
    }

    @DeleteMapping("/delete-healthinsurance")
    private HealthInsurance delete(@RequestBody HealthInsurance healthInsurance){
        healthInsurance.setStatus(false);
        return this.healthInsuranceRepository.save(healthInsurance);
    }
}
