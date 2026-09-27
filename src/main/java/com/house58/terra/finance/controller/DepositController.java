package com.house58.terra.finance.controller;

import com.house58.terra.finance.dao.BalanceRepository;
import com.house58.terra.finance.dao.CostRepository;
import com.house58.terra.finance.dao.InvoiceRepository;
import com.house58.terra.finance.dao.MovementInputRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/deposito")
public class DepositController {

    private final BalanceRepository balanceRepository;
    private final CostRepository costRepository;
    private final InvoiceRepository invoiceRepository;
    private final MovementInputRepository movementRepository;

    public DepositController(BalanceRepository balanceRepository, CostRepository costRepository, InvoiceRepository invoiceRepository, MovementInputRepository movementRepository){
        this.balanceRepository = balanceRepository;
        this.costRepository = costRepository;
        this.invoiceRepository = invoiceRepository;
        this.movementRepository = movementRepository;
    }
/*
    @PostMapping
    private Shedule save(@RequestBody Shedule shedule){

        return this.sheduleRepository.save(shedule);
    }

    @PutMapping
    private Shedule update(@RequestBody Shedule shedule){
        return this.sheduleRepository.save(shedule);
    }

    @DeleteMapping
    private Shedule delete(@RequestBody Shedule shedule){
        // shedule.setStatus(false);
        return this.sheduleRepository.save(shedule);
    }
*/
}
