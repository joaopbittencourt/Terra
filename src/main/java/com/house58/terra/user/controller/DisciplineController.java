package com.house58.terra.user.controller;


import com.house58.terra.user.dao.DisciplineRepository;
import com.house58.terra.user.dao.TeamRepository;
import com.house58.terra.user.entity.Discipline;
import com.house58.terra.user.entity.Team;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/discipline")
public class DisciplineController {
    private final DisciplineRepository disciplineRepository;

    public DisciplineController(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    @GetMapping("/list-discipline")
    private List<Discipline> get(){
        return this.disciplineRepository.findAll();
    }

    @PostMapping("/save-disipline")
    private Discipline save(@RequestBody Discipline discipline){
        return this.disciplineRepository.save(discipline);
    }

    @DeleteMapping("/delete-disciplne")
    private Discipline delete(@RequestBody Discipline discipline){
        //team.setStatus(false);
        return this.disciplineRepository.save(discipline);
    }
}
