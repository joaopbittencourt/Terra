package com.house58.terra.contract.controller;

import com.house58.terra.contract.dao.ContractRepository;
import com.house58.terra.contract.dto.AnamnesisDTO;
import com.house58.terra.contract.entity.Contract;
import com.house58.terra.contract.service.RegisterAppointment;
import com.house58.terra.contract.service.RegisterContract;
import com.house58.terra.contract.service.RegisterPatient;
import org.springframework.web.bind.annotation.*;
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
    private Contract register(@RequestBody AnamnesisDTO anamnesisDTO){
        return this.registerContract.register(anamnesisDTO);
    }

    /*
    @PostMapping("effectuated")
    private Contract effectuated(@RequestBody Contract contract){
        Contract contract1 = this.registerContract.effectuated(contract);
        Patient patient = this.registerAppointment.register(contract1.getPatient(), contract1.getSessionsId());
        return contract1;
    }*/

    @DeleteMapping("/delete-contract")
    private Contract delete(@RequestBody Contract contract){
        contract.setStatus(false);
        return this.contractRepository.save(contract);
    }
}
