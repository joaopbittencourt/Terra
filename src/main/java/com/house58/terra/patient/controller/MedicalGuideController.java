package com.house58.terra.patient.controller;

import com.house58.terra.patient.entity.MedicalGuide;
import com.house58.terra.patient.service.MedicalGuideRegistration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guide")
public class MedicalGuideController {
    private final MedicalGuideRegistration medicalGuideRegistration;

    public MedicalGuideController(MedicalGuideRegistration medicalGuideRegistration){
        this.medicalGuideRegistration = medicalGuideRegistration;
    }

    @PostMapping("save-medical-guide")
    public MedicalGuide register(@RequestBody MedicalGuide medicalGuide){
        return this.medicalGuideRegistration.register(medicalGuide);
    }

    @GetMapping("/")
    private List<MedicalGuide> findAll(){
        return this.medicalGuideRegistration.listAll();
    }

}
