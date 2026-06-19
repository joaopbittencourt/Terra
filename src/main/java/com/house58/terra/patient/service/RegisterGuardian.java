package com.house58.terra.patient.service;

import com.house58.terra.patient.dao.GuardianRepository;
import com.house58.terra.patient.entity.Guardians;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public class RegisterGuardian {
    private final GuardianRepository guardianRepository;

    public RegisterGuardian(GuardianRepository guardianRepository) {
        this.guardianRepository = guardianRepository;
    }

    public Guardians getGuardianRepository(Long cpf) {
        return this.guardianRepository.findGuardianByCpf(cpf);
    }

    public Guardians register(Guardians guardian){
        return this.guardianRepository.saveAndFlush(guardian);
    }
}
