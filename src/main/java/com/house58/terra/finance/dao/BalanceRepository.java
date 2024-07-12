package com.house58.terra.finance.dao;

import com.house58.terra.finance.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BalanceRepository extends JpaRepository<Balance, UUID> {
}
