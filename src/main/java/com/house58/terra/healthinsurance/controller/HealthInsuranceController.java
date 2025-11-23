package com.house58.terra.healthinsurance.controller;

import com.house58.terra.healthinsurance.dao.HealthInsuranceRepository;
import com.house58.terra.healthinsurance.entity.HealthInsurance;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    private List<HealthInsurance> findAll(){
        return this.healthInsuranceRepository.findAll();
    }

    @DeleteMapping("/delete-healthinsurance")
    private HealthInsurance delete(@RequestBody HealthInsurance healthInsurance){
        healthInsurance.setStatus(false);
        return this.healthInsuranceRepository.save(healthInsurance);
    }
}
