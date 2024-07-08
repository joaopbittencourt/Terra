package com.house58.terra.patient.controller;

import com.house58.terra.patient.dao.CheckingRepository;
import com.house58.terra.patient.entity.Checking;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("checking")
public class CheckingController {
    private final CheckingRepository checkingRepository;

    CheckingController(CheckingRepository checkingRepository){
        this.checkingRepository = checkingRepository;
    }
    @PostMapping
    private void check(@RequestBody Checking request){
        this.checkingRepository.save(request);
    }
}
