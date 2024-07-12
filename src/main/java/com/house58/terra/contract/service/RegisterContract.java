package com.house58.terra.contract.service;

import com.house58.terra.contract.dao.ContractRepository;
import com.house58.terra.contract.dto.AnamnesisDTO;
import com.house58.terra.contract.entity.Contract;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;


@Service
public class RegisterContract {
    private final ContractRepository contractRepository;

    public RegisterContract(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public Contract register(AnamnesisDTO anamnesisDTO){
        Contract contract = new Contract();
        contract.setPatient(anamnesisDTO.getResponsible().getPatient());
        contract.setDisciplineAnamneseDTO(anamnesisDTO.getDisciplineAnamneseDTO());
        contract.setStatus(Boolean.FALSE);
        return this.contractRepository.save(contract);
    }

    public Contract effectuated (Contract contract){
        contract.setEffetiveDate(new Date(System.currentTimeMillis()));
        contract.setDateOfValidity(soma12Month(new Date(System.currentTimeMillis())));
        contract.setStatus(Boolean.TRUE);
        return this.contractRepository.save(contract);
    }

    public Contract finalizeContract(Contract contract){
        contract.setStatus(Boolean.FALSE);
        return this.contractRepository.save(contract);
    }

    private static Date soma12Month(Date data) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        calendar.set(Calendar.DAY_OF_YEAR,
                calendar.getMaximum(Calendar.DAY_OF_YEAR)); // seta para o último dia
        return calendar.getTime();
    }

}
