package com.courses.services;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.courses.business.transactions.DebitoTransactions;
import com.courses.models.Cuenta;
import com.courses.repositories.ICuentaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransferenciaService {

    private final ICuentaRepository cuentaRepository;
    private final DebitoTransactions debitoTransactions;

    public Optional<Cuenta> getCuentaById(String accountNumber) {
        Optional<Cuenta> cuenta = cuentaRepository.getCuenta(accountNumber);
        return cuenta;
    }

    public boolean startTransferencia() {
        /* Cuenta cuenta = Cuenta.builder()
            .name("Usuario 1")
            .accountNumber("123456789")
            .amount(new BigDecimal("10000"))
            .build(); */
        Cuenta cuenta = null;
        Cuenta cuentaDos = Cuenta.builder()
            .name("Usuario 2")
            .accountNumber("987654321")
            .amount(new BigDecimal("200"))
            .build();
        
        debitoTransactions.transferencias(cuenta, cuentaDos, new BigDecimal("1000"));

        return true;

    }
    

}
