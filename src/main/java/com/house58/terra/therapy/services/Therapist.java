package com.house58.terra.therapy.services;

import com.house58.terra.therapy.dao.TherapyRepository;
import com.house58.terra.therapy.entity.Therapy;
import com.house58.terra.user.dao.TeamRepository;
import com.house58.terra.user.entity.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Therapist {
    private TeamRepository teamRepository;
    private TherapyRepository therapyRepository;

    public Therapist(TeamRepository teamRepository, TherapyRepository therapyRepository) {
        this.teamRepository = teamRepository;
        this.therapyRepository = therapyRepository;
    }

    public Team  register(Therapy therapy, Team team){
        ArrayList<Therapy> listTherapy = new ArrayList<Therapy>();

        listTherapy.add(this.therapyRepository.getById(therapy.getId()));
        Team teamC = this.teamRepository.getById(team.getId());
        teamC.setDiscipline(listTherapy);
        return this.teamRepository.save(teamC);
    }
}
