package com.house58.terra.therapy.controller;


import com.house58.terra.therapy.dao.TherapyRepository;
import com.house58.terra.therapy.entity.Therapy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/therapy")
public class TherapyController {
    private final TherapyRepository therapyRepository;

    public TherapyController(TherapyRepository therapyRepository) {
        this.therapyRepository = therapyRepository;
    }

    @GetMapping("/list-therapy")
    private List<Therapy> get(){
        return this.therapyRepository.findAll();
    }

    @PostMapping("/save-therapy")
    private Therapy save(@RequestBody Therapy therapy){
        return this.therapyRepository.save(therapy);
    }

    @DeleteMapping("/delete-therapy")
    private Therapy delete(@RequestBody Therapy therapy){
        //team.setStatus(false);
        return this.therapyRepository.save(therapy);
    }
}
