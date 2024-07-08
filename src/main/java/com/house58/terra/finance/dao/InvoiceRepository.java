package com.house58.terra.finance.dao;

import com.house58.terra.contract.entity.HealthInsurance;
import com.house58.terra.finance.entity.Invoice;
import com.house58.terra.finance.entity.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Movement, Integer> {
}
