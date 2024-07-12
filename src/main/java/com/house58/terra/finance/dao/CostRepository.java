package com.house58.terra.finance.dao;

import com.house58.terra.finance.entity.Cost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CostRepository extends JpaRepository<Cost, UUID> {
}
