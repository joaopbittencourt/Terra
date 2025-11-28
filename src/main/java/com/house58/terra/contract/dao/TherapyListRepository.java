package com.house58.terra.contract.dao;

import com.house58.terra.contract.entity.TherapyList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TherapyListRepository extends JpaRepository<TherapyList, UUID> {
}
