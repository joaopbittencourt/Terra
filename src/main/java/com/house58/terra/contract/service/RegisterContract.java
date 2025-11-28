package com.house58.terra.contract.service;

import com.house58.terra.contract.dao.ContractRepository;
import com.house58.terra.contract.dto.AnamnesisDTO;
import com.house58.terra.contract.dto.TherapyPatientDTO;
import com.house58.terra.contract.entity.CarePlan;
import com.house58.terra.contract.entity.Contract;
import com.house58.terra.contract.entity.TherapyList;
import com.house58.terra.healthinsurance.entity.HealthInsurance;
import com.house58.terra.modality.entity.Modality;
import com.house58.terra.patient.entity.Patient;
import com.house58.terra.therapy.entity.Therapy;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class RegisterContract {
    private final ContractRepository contractRepository;

    public RegisterContract(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }
/*
    public Contract register(AnamnesisDTO anamnesisDTO){
        Contract contract = new Contract();
        contract.setPatient(anamnesisDTO.getResponsible().getPatient());
        contract.setTherapyAnamneseDTO(anamnesisDTO.getTherapyAnamneseDTO());
        contract.setStatus(Boolean.FALSE);
        return this.contractRepository.save(contract);
    }
*/

    public Contract register(Patient patient, HealthInsurance healthInsurance, Modality modality, List<TherapyList> therapyList, Date effetiveDate, Date dateOfValidity){
        Contract contract = new Contract();
        contract.setPatient(patient);
        contract.setTherapyLists(therapyList);
        contract.setEffetiveDate(effetiveDate);
        contract.setDateOfValidity(dateOfValidity);
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
