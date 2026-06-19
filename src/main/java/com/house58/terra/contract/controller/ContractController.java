package com.house58.terra.contract.controller;

import com.house58.terra.contract.dao.ContractRepository;
import com.house58.terra.contract.dto.HealthPlanDTO;
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
import java.util.UUID;

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
    private Contract register(@RequestBody Patient patient, @RequestBody HealthInsurance healthInsurance, @RequestBody Modality modality){
        return this.registerContract.register(patient, healthInsurance,  modality);
    }

    @PostMapping("/register-plan/{patientId}")
    private Contract registerPlan(@PathVariable UUID patientId, @RequestBody HealthPlanDTO healthPlanDTO){
        return registerContract.registerPlanCode(patientId, healthPlanDTO);
    }
    @PostMapping("/register-modality/{patientId}")
    private Contract registerModality(@PathVariable UUID patientId, @RequestBody Modality modality){
        return registerContract.registerModality(patientId, modality);
    }


    @GetMapping("/patient/{patientId}")
    private List<Contract> getContractByPatient(@PathVariable UUID patientId){
        return registerContract.findContractByPatient(patientId);
    }

    @PostMapping("/effectuated-contract")
    private Contract effectuated(@RequestBody Contract contract){
        return this.registerContract.effectuated(contract);
    }

    @GetMapping
    private List<Contract> findAll(){
        return this.contractRepository.findAll();
    }


    public RegisterPatient getRegisterPatient() {
        return registerPatient;
    }
}
