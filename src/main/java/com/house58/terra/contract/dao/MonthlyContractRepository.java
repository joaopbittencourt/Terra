package com.house58.terra.contract.dao;

import com.house58.terra.contract.entity.Contract;
import com.house58.terra.contract.entity.MonthlyContract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MonthlyContractRepository extends JpaRepository<MonthlyContract, UUID> {
}
