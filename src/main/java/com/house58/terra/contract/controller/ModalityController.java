package com.house58.terra.contract.controller;

import com.house58.terra.contract.dao.ModalityRepository;
import com.house58.terra.contract.entity.Modalito;
import org.springframework.web.bind.annotation.*;

@RestController("modality")
public class ModalityController {
    private final ModalityRepository modalityRepository;

    public ModalityController(ModalityRepository modalityRepository) {
        this.modalityRepository = modalityRepository;
    }
    @PostMapping
    private Modalito save(@RequestBody Modalito modalito){
        return this.modalityRepository.save(modalito);
    }

    @PutMapping
    private Modalito update(@RequestBody Modalito modalito){
        return this.modalityRepository.save(modalito);
    }

    @DeleteMapping
    private Modalito delete(@RequestBody Modalito modalito){
        modalito.setStatus(false);
        return this.modalityRepository.save(modalito);
    }
}
