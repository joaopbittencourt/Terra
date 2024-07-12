package com.house58.terra.patient.controller;

import com.house58.terra.patient.dao.ResponsibleRepository;
import com.house58.terra.patient.entity.Responsible;
import org.springframework.web.bind.annotation.*;

@RestController 
@RequestMapping("/responsible")
public class ResponsibleController {
    private final ResponsibleRepository responsibleRepository;
    ResponsibleController(ResponsibleRepository responsibleRepository){
        this.responsibleRepository = responsibleRepository;
    }

    @PostMapping("/save-responsable")
    private Responsible save(@RequestBody Responsible responsible){
        responsible.setStatus(true);
        return this.responsibleRepository.save(responsible);
    }
    @DeleteMapping("/delete-responsable")
    private Responsible remove(@RequestBody Responsible responsible){
        responsible.setStatus(false);
        return this.responsibleRepository.save(responsible);
    }




}
