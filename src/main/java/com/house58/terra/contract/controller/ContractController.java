package com.house58.terra.contract.controller;

import com.house58.terra.contract.dao.ContractRepository;
import com.house58.terra.contract.dto.AnamnesisDTO;
import com.house58.terra.contract.dto.PatientDTO;
import com.house58.terra.contract.entity.Contract;
import com.house58.terra.contract.service.RegisterAppointment;
import com.house58.terra.contract.service.RegisterContract;
import com.house58.terra.contract.service.RegisterPatient;
import com.house58.terra.patient.entity.Patient;
import org.springframework.web.bind.annotation.*;
//contrato
@RestController("contract")
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

    @PostMapping
    private Contract save(@RequestBody Contract contract){
        return this.contractRepository.save(contract);
    }

    @PostMapping
    private Contract register(@RequestBody AnamnesisDTO anamnesisDTO){
        return this.registerContract.register(anamnesisDTO);
    }

    @PostMapping("effectuated")
    private Contract effectuated(@RequestBody Contract contract){
        Contract contract1 = this.registerContract.effectuated(contract);
        Patient patient = this.registerAppointment.register(contract1.getPatient(), contract1.getSessionsId());
        return contract1;
    }

    @PutMapping
    private Contract update(@RequestBody Contract contract){
        return this.contractRepository.save(contract);
    }

    @DeleteMapping
    private Contract delete(@RequestBody Contract contract){
        contract.setStatus(false);
        return this.contractRepository.save(contract);
    }
}
