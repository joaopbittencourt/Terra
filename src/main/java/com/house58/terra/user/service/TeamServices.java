package com.house58.terra.user.service;

import com.house58.terra.user.dao.TeamRepository;
import com.house58.terra.user.entity.Team;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class TeamServices {
    private  final TeamRepository teamRepository;

    public TeamServices(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Team save(Team team) throws Exception {

        Optional<Team> t;
        Team teamNow;
        if(null != team.getId() ){
            t =  this.teamRepository.findById(team.getId());
            if(!t.isPresent())
                throw new Exception("Terapeuta não encontrado");
            teamNow = team;

        }else{
            teamNow = team;
        }

        teamNow.setSession(String.join(",",team.getSessionsId()));
        teamNow.setTherapies(team.getTherapies());
        teamNow.setContractType(team.getContractType());
        teamNow.setRemuneration(team.getRemuneration());
        teamNow.setLastModify(Timestamp.from(Instant.now()));
        return this.teamRepository.save(teamNow);
    }

    public List<Team> findAll(){

        List<Team> teams = this.teamRepository.findAll();
        System.out.println(teams.getFirst().getId());
        List<Team> teamsDTO = new ArrayList<Team>();
        for (Team t : teams){
            if(null != t.getSession())
                t.setSessionsId(List.of(t.getSession().split(",")));
            teamsDTO.add(t);
        }
        return teamsDTO;
    }
}
