package com.house58.terra.user.controller;

import com.house58.terra.user.dao.TeamRepository;
import com.house58.terra.user.entity.Team;
import org.springframework.web.bind.annotation.*;

@RestController("team")
public class TeamController {
    private final TeamRepository teamRepository;

    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @PostMapping
    private Team save(@RequestBody Team team){
        return this.teamRepository.save(team);
    }
    @PutMapping
    private Team update(@RequestBody Team team){
        return this.teamRepository.save(team);
    }
    @DeleteMapping
    private Team delete(@RequestBody Team team){
        //team.setStatus(false);
        return this.teamRepository.save(team);
    }

}
