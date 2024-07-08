package com.house58.terra.contract.controller;

import com.house58.terra.contract.dao.AnamnesisRepository;
import com.house58.terra.contract.dto.AnamnesisDTO;
import com.house58.terra.contract.service.RegisterAnamnesis;
import com.house58.terra.patient.entity.Anamnesis;
import com.house58.terra.patient.enumm.StatusEnum;
import org.springframework.web.bind.annotation.*;

//contrato
@RestController("anamnesis")
public class AnamnesisController {
    private final AnamnesisRepository anamnesisRepository ;
    private final RegisterAnamnesis registerAnamnesis;
    public AnamnesisController(AnamnesisRepository anamnesisRepository, RegisterAnamnesis registerAnamnesis) {
        this.anamnesisRepository = anamnesisRepository;
        this.registerAnamnesis = registerAnamnesis;
    }

    @PostMapping
    private Anamnesis save(@RequestBody Anamnesis anamnesis){
        return this.anamnesisRepository.save(anamnesis);
    }

    @PostMapping
    private void register(@RequestBody AnamnesisDTO anamnesis){
        this.registerAnamnesis.register(anamnesis);
    }

    @PutMapping
    private Anamnesis begin(@RequestBody Anamnesis anamnesis){
        anamnesis.setStatusEnum(StatusEnum.REALIZED);
        return this.anamnesisRepository.save(anamnesis);
    }

    @DeleteMapping
    private Anamnesis delete(@RequestBody Anamnesis anamnesis){
        return this.anamnesisRepository.save(anamnesis);
    }
}
