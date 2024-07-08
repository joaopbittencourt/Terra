package com.house58.terra.patient.controller;

import com.house58.terra.patient.dao.PatientRepository;
import com.house58.terra.patient.dao.ResponsibleRepository;
import com.house58.terra.patient.entity.Patient;
import com.house58.terra.patient.entity.Responsible;
import org.springframework.web.bind.annotation.*;

@RestController("responsible")
public class ResponsibleController {
    private final ResponsibleRepository responsibleRepository;
    ResponsibleController(ResponsibleRepository responsibleRepository){
        this.responsibleRepository = responsibleRepository;
    }

    @PostMapping
    private Responsible save(@RequestBody Responsible responsible){
        responsible.setStatus(true);
        return this.responsibleRepository.save(responsible);
    }
    @PutMapping
    private Responsible update(@RequestBody Responsible responsible){
        return this.responsibleRepository.save(responsible);
    }
    @DeleteMapping
    private Responsible remove(@RequestBody Responsible responsible){
        responsible.setStatus(false);
        return this.responsibleRepository.save(responsible);
    }




}
