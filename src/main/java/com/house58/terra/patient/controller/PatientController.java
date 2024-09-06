package com.house58.terra.patient.controller;

import com.house58.terra.patient.dao.PatientRepository;
import com.house58.terra.patient.entity.Patient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController 
@RequestMapping("/patient")
public class PatientController {
    private final PatientRepository patientRepository;
    PatientController(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    @PostMapping("/save-patient")
    private Patient save(@RequestBody Patient patient){
        patient.setStatus(true);
        return this.patientRepository.save(patient);
    }

    @GetMapping
    private List<Patient> findAll(){
        return this.patientRepository.findAll();
    }
    @DeleteMapping("/delete-patient")
    private Patient remove(@RequestBody Patient patient){
        patient.setStatus(false);
        return this.patientRepository.save(patient);
    }




}
