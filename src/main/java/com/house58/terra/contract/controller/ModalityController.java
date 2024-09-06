package com.house58.terra.contract.controller;

import com.house58.terra.contract.dao.ModalityRepository;
import com.house58.terra.contract.entity.Modaliity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController 
@RequestMapping("/modality")
public class ModalityController {
    private final ModalityRepository modalityRepository;

    public ModalityController(ModalityRepository modalityRepository) {
        this.modalityRepository = modalityRepository;
    }
    @PostMapping("/save-modality")
    private Modaliity save(@RequestBody Modaliity modaliity){
        return this.modalityRepository.save(modaliity);
    }

    @GetMapping
    private List<Modaliity> findAll(){
        return this.modalityRepository.findAll();
    }

    @DeleteMapping("/delete-modality")
    private Modaliity delete(@RequestBody Modaliity modaliity){
        modaliity.setStatus(false);
        return this.modalityRepository.save(modaliity);
    }
}
