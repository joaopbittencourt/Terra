package com.house58.terra.patient.controller;

import com.house58.terra.patient.dao.PatientRepository;
import com.house58.terra.patient.entity.Patient;
import org.springframework.web.bind.annotation.*;

@RestController("patient")
public class PatientController {
    private final PatientRepository patientRepository;
    PatientController(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    @PostMapping
    private Patient save(@RequestBody Patient patient){
        patient.setStatus(true);
        return this.patientRepository.save(patient);
    }
    @PutMapping
    private Patient update(@RequestBody Patient patient){
        return this.patientRepository.save(patient);
    }
    @DeleteMapping
    private Patient remove(@RequestBody Patient patient){
        patient.setStatus(false);
        return this.patientRepository.save(patient);
    }




}
