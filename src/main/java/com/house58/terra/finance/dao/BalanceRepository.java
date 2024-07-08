package com.house58.terra.finance.dao;

import com.house58.terra.contract.entity.CarePlan;
import com.house58.terra.finance.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceRepository extends JpaRepository<Balance, Integer> {
}
