package com.house58.terra.finance.controller;

import com.house58.terra.finance.entity.MovementOutput;
import com.house58.terra.finance.service.MakePayment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/pagamento")
public class PaymentController {
    private final MakePayment makePayment;

    public PaymentController(MakePayment makePayment) {
        this.makePayment = makePayment;
    }
}
