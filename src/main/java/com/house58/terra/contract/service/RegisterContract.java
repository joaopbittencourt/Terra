package com.house58.terra.contract.service;

import com.house58.terra.contract.dao.ContractRepository;
import com.house58.terra.contract.dto.HealthPlanDTO;
import com.house58.terra.contract.entity.Contract;
import com.house58.terra.contract.entity.TherapyList;
import com.house58.terra.healthinsurance.dao.HealthInsuranceRepository;
import com.house58.terra.healthinsurance.entity.HealthInsurance;
import com.house58.terra.modality.dao.ModalityRepository;
import com.house58.terra.modality.entity.Modality;
import com.house58.terra.patient.dao.PatientRepository;
import com.house58.terra.patient.entity.Patient;
import org.eclipse.angus.mail.util.UUDecoderStream;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class RegisterContract {
    private final ContractRepository contractRepository;
    private final HealthInsuranceRepository healthInsuranceRepository;
    private final PatientRepository patientRepository;
    private final ModalityRepository modalityRepository;


    public RegisterContract(ContractRepository contractRepository, HealthInsuranceRepository healthInsuranceRepository, PatientRepository patientRepository, ModalityRepository modalityRepository) {
        this.contractRepository = contractRepository;
        this.healthInsuranceRepository = healthInsuranceRepository;
        this.patientRepository = patientRepository;
        this.modalityRepository = modalityRepository;
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

    public Contract register(Patient patient, HealthInsurance healthInsurance, Modality modality){
        Contract contract = new Contract();
        contract.setPatient(patient);
        contract.setHealthInsurance(healthInsurance);
        contract.setModality(modality);
        return  this.contractRepository.save(contract);

    }

    public Contract registerPlanCode(UUID patientId, HealthPlanDTO healthPlanDTO) {
        Patient patient = this.patientRepository.getById(patientId);

        HealthInsurance plan = this.healthInsuranceRepository.getById(healthPlanDTO.getPlanCode());

        System.out.println("Plano: "+plan.getId());

        if(null == plan)
            throw new RuntimeException("Plano de saude não encontrado");

        if(null == patient)
            throw new RuntimeException("Paciente não encontrado");

        Contract contract = null ;
        for(Contract con: patient.getContracts()){
            if(con.getStatus()){
                contract = this.contractRepository.getById(con.getId());
                contract.setHealthInsurance(plan);
                break;
            }
        }

        if(contract == null){
            contract = new Contract();
            contract.setHealthInsurance(plan);
            contract.setPatient(patient);
            contract.setEffetiveDate(new Date(System.currentTimeMillis()));
            //CONTRATO 12 MESES
            contract.setDateOfValidity(soma12Month(new Date(System.currentTimeMillis())));
            contract.setStatus(Boolean.TRUE);
        }
        System.out.println("Contrato health: "+contract.getHealthInsurance().getId());
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

    public List<Contract> findContractByPatient(UUID patientId) {
        Patient patient = this.patientRepository.getById(patientId);

        if(null == patient)
            throw  new RuntimeException("Paciente não encontrado");

        return this.contractRepository.findContractByPatient(patient);
    }

    public Contract registerModality(UUID patientId, Modality modality) {
        Patient patient = this.patientRepository.getById(patientId);
        Modality modality1 = this.modalityRepository.getById(modality.getId());


        if(null == modality1)
            throw new RuntimeException("Modalidade não encontrado");

        if(null == patient)
            throw new RuntimeException("Paciente não encontrado");


        Contract contract = null ;
        for(Contract con: patient.getContracts()){
            if(con.getStatus()){
                contract = this.contractRepository.getById(con.getId());
                if(contract.getDateOfValidity().compareTo(new Date(System.currentTimeMillis())) > 0){
                    contract.setStatus(false);
                    this.contractRepository.save(contract);
                    throw new RuntimeException("Contrato com data vencida não pode ser alterado");
                }

                contract.setModality(modality1);

                break;
            }
        }

        if(contract == null){
            contract = new Contract();
            contract.setModality(modality1);
            contract.setPatient(patient);
            contract.setEffetiveDate(new Date(System.currentTimeMillis()));
            //CONTRATO 12 MESES
            contract.setDateOfValidity(soma12Month(new Date(System.currentTimeMillis())));
        }
        contract.setStatus(Boolean.TRUE);

        return this.contractRepository.save(contract);
    }
}
