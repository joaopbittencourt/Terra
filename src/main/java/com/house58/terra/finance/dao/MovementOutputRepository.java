package com.house58.terra.finance.dao;

import com.house58.terra.finance.entity.MovementOutput;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MovementOutputRepository extends JpaRepository<MovementOutput, UUID> {
}
