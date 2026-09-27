package com.house58.terra.finance.service;

import com.house58.terra.finance.dao.MovementInputRepository;
import com.house58.terra.finance.entity.MovementInput;
import com.house58.terra.finance.enumm.PaymentMethodEnum;
import com.house58.terra.patient.entity.Patient;
import org.springframework.security.oauth2.jwt.Jwt;

import java.sql.Timestamp;
import java.time.Instant;

public class ReceiveDeposit {

    private final MovementInputRepository movementInputRepository;

    public ReceiveDeposit(MovementInputRepository movementInputRepository) {
        this.movementInputRepository = movementInputRepository;
    }

    private MovementInput registerMovemenmt(String description, Double value, PaymentMethodEnum paymentMethodEnum, Jwt jwt){
        MovementInput movementInput1 = new MovementInput();
        movementInput1.setDescription(description);
        movementInput1.setValue(value);
        movementInput1.setUser(jwt.getClaim("preferred_username").toString());
        movementInput1.setCreatedAt(Timestamp.from(Instant.now()));

        return this.movementInputRepository.save(movementInput1);
    }
}
