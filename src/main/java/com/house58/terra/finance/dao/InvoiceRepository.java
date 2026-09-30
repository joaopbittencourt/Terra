package com.house58.terra.finance.dao;

import com.house58.terra.finance.entity.MovementInput;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InvoiceRepository extends JpaRepository<MovementInput, UUID> {
}
