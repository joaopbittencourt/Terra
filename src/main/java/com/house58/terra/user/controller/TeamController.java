package com.house58.terra.user.controller;

import com.house58.terra.user.dao.TeamRepository;
import com.house58.terra.user.entity.Team;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController 
@RequestMapping("/team")
public class TeamController {
    private final TeamRepository teamRepository;

    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }


    @GetMapping("/list-team")
    private List<Team> save(){
        return this.teamRepository.findAll();
    }

    @PostMapping("/save-team")
    private Team save(@RequestBody Team team){
        return this.teamRepository.save(team);
    }

    @DeleteMapping("/delete-team")
    private Team delete(@RequestBody Team team){
        //team.setStatus(false);
        return this.teamRepository.save(team);
    }

}
