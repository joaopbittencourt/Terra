package com.house58.terra.user.dao;

import com.house58.terra.user.entity.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DisciplineRepository extends JpaRepository<Discipline, UUID> {

}
