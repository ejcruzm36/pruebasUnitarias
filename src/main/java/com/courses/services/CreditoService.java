package com.courses.services;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.courses.business.credits.CreditCalculator;
import com.courses.models.Credito;
import com.courses.models.Cuenta;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreditoService {

    private final CreditCalculator creditCalculator;

    public Credito getCredito(BigDecimal amount, String type, Integer months) {
        Cuenta cuenta = Cuenta.builder()
            .name("Usuario 1")
            .accountNumber("123456789")
            .amount(BigDecimal.ZERO)
            .build();
        Credito credito = Credito.builder()
            .id("1")
            .type("H")
            .amount(amount)
            .amountTotal(BigDecimal.ZERO)
            .cout(BigDecimal.ZERO)
            .months(12)
            .account(cuenta)
            .build();

        BigDecimal totalPago = creditCalculator.setCreditToClient(amount, type, months, credito);
        BigDecimal cout = creditCalculator.calculateCout(totalPago, months);

        credito.setCout(cout);
        credito.setAmountTotal(totalPago);

        return credito;

    }

}
