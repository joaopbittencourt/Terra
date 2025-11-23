package com.house58.terra.modality.controller;


import com.house58.terra.modality.dao.ModalityRepository;
import com.house58.terra.modality.entity.Modality;
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
    private Modality save(@RequestBody Modality modality){
        return this.modalityRepository.save(modality);
    }

    @GetMapping
    private List<Modality> findAll(){
        return this.modalityRepository.findAll();
    }

    @DeleteMapping("/delete-modality")
    private Modality delete(@RequestBody Modality modality){
        modality.setStatus(false);
        return this.modalityRepository.save(modality);
    }
}
