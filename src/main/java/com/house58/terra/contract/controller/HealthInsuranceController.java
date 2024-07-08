package com.house58.terra.contract.controller;

import com.house58.terra.contract.dao.HealthInsuranceRepository;
import com.house58.terra.contract.entity.HealthInsurance;
import org.springframework.web.bind.annotation.*;

@RestController("healthinsurance")
public class HealthInsuranceController {
    private final HealthInsuranceRepository healthInsuranceRepository ;

    public HealthInsuranceController(HealthInsuranceRepository healthInsuranceRepository) {
        this.healthInsuranceRepository = healthInsuranceRepository;
    }
    @PostMapping
    private HealthInsurance save(@RequestBody HealthInsurance healthInsurance){
        return this.healthInsuranceRepository.save(healthInsurance);
    }

    @PutMapping
    private HealthInsurance update(@RequestBody HealthInsurance healthInsurance){
        return this.healthInsuranceRepository.save(healthInsurance);
    }

    @DeleteMapping
    private HealthInsurance delete(@RequestBody HealthInsurance healthInsurance){
        healthInsurance.setStatus(false);
        return this.healthInsuranceRepository.save(healthInsurance);
    }
}
