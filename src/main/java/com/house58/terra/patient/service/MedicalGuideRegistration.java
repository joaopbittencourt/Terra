package com.house58.terra.patient.service;

import com.house58.terra.patient.dao.MedicalGuideRepository;
import com.house58.terra.patient.entity.MedicalGuide;

import java.util.List;

public class MedicalGuideRegistration {
    private final MedicalGuideRepository medicalGuideRepository;

    public MedicalGuideRegistration(MedicalGuideRepository medicalGuideRegistration) {
        this.medicalGuideRepository = medicalGuideRegistration;
    }

    public MedicalGuide register(MedicalGuide medicalGuide){
        return this.medicalGuideRepository.save(medicalGuide);
    }

    public List<MedicalGuide> listAll(){
        return this.medicalGuideRepository.findAll();
    }
}
