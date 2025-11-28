package com.house58.terra.contract.controller;

import com.house58.terra.contract.dao.ContractRepository;
import com.house58.terra.contract.dto.AnamnesisDTO;
import com.house58.terra.contract.entity.CarePlan;
import com.house58.terra.contract.entity.Contract;
import com.house58.terra.contract.entity.TherapyList;
import com.house58.terra.contract.service.RegisterAppointment;
import com.house58.terra.contract.service.RegisterContract;
import com.house58.terra.healthinsurance.entity.HealthInsurance;
import com.house58.terra.modality.entity.Modality;
import com.house58.terra.patient.entity.Patient;
import com.house58.terra.patient.service.RegisterPatient;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

//contrato
@RestController 
@RequestMapping("/contract")
public class ContractController {
    private final ContractRepository contractRepository ;
    private final RegisterPatient registerPatient;
    private final RegisterContract registerContract;
    private final RegisterAppointment registerAppointment;
    public ContractController(ContractRepository contractRepository, RegisterPatient registerPatient, RegisterContract registerContract,
                              RegisterAppointment registerAppointment) {
        this.contractRepository = contractRepository;
        this.registerPatient = registerPatient;
        this.registerContract = registerContract;
        this.registerAppointment = registerAppointment;
    }

    @PostMapping("/register-contract")
    private Contract register(@RequestBody Patient patient, @RequestBody HealthInsurance healthInsurance, @RequestBody Modality modality, @RequestBody List<TherapyList> therapyLists, @RequestBody Date effetiveDate, @RequestBody Date dateOfValidity){
        return this.registerContract.register(patient, healthInsurance,  modality, therapyLists, effetiveDate, dateOfValidity);
    }

    @GetMapping
    private List<Contract> findAll(){
        return this.contractRepository.findAll();
    }



    public RegisterPatient getRegisterPatient() {
        return registerPatient;
    }
}
