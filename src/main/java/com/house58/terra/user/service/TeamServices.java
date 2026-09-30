package com.house58.terra.user.service;

import com.house58.terra.schedule.dao.SheduleRepository;
import com.house58.terra.schedule.entity.Session;
import com.house58.terra.schedule.enumm.SessionIdEnum;
import com.house58.terra.user.dao.TeamRepository;
import com.house58.terra.user.entity.Team;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
public class TeamServices {
    private  final TeamRepository teamRepository;
    private final SheduleRepository sheduleRepository;

    public TeamServices(TeamRepository teamRepository, SheduleRepository sheduleRepository) {
        this.teamRepository = teamRepository;
        this.sheduleRepository = sheduleRepository;
    }

    public Team save(Team team) throws Exception {

        Optional<Team> t;
        Team teamNow;
        if(null != team.getId() ){
            t =  this.teamRepository.findById(team.getId());
            if(!t.isPresent())
                throw new Exception("Terapeuta não encontrado");
            teamNow = t.get();
            List<String> l = new ArrayList<>();
            l.addAll(List.of(teamNow.getSession().split(",")));
            List<String> negativeSession = l.stream().filter(s -> {
                return !team.getSessionsId().contains(s);
            }).toList();

            if(!negativeSession.isEmpty()) {
                System.out.println(negativeSession.toString());
                this.sheduleRepository.removeSchedulesByTeam(team, negativeSession);
            }
            teamNow = team;

        }else{


            teamNow = team;
        }

        teamNow.setSession(String.join(",",team.getSessionsId()));



        teamNow.setTherapies(team.getTherapies());
        teamNow.setContractType(team.getContractType());
        teamNow.setRemuneration(team.getRemuneration());
        teamNow.setLastModify(Timestamp.from(Instant.now()));
        System.out.println(teamNow);
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
