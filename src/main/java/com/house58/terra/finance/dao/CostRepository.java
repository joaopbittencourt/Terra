package com.house58.terra.finance.dao;

import com.house58.terra.contract.entity.Contract;
import com.house58.terra.finance.entity.Cost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostRepository extends JpaRepository<Cost, Integer> {
}
