package com.house58.terra.finance.dao;

import com.house58.terra.contract.entity.HealthInsurance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MovementRepository extends JpaRepository<HealthInsurance, UUID> {
}
