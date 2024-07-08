package com.house58.terra.schedule.dao;

import com.house58.terra.schedule.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
