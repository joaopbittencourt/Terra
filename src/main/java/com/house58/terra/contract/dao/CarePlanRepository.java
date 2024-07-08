package com.house58.terra.contract.dao;

import com.house58.terra.contract.entity.CarePlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarePlanRepository extends JpaRepository<CarePlan, Integer> {
}
