package com.house58.terra.user.controller;

import com.house58.terra.user.dao.TeamRepository;
import com.house58.terra.user.entity.Team;
import com.house58.terra.user.service.TeamServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController 
@RequestMapping("/team")
public class TeamController {
    private final TeamRepository teamRepository;
    private final TeamServices teamServices;

    public TeamController(TeamRepository teamRepository, TeamServices teamServices) {
        this.teamRepository = teamRepository;
        this.teamServices = teamServices;
    }

    @GetMapping()
    private List<Team> save(){
        return this.teamServices.findAll();
    }

    @PostMapping("/save-team")
    private Team save(@RequestBody Team team) throws Exception {
        return this.teamServices.save(team);
    }

    @DeleteMapping("/delete-team")
    private Team delete(@RequestBody Team team){
        //team.setStatus(false);
        return this.teamRepository.save(team);
    }

}
