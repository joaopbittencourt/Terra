package com.house58.terra.schedule.dao;

import com.house58.terra.schedule.entity.Shedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SheduleRepository extends JpaRepository<Shedule, UUID> {
}
