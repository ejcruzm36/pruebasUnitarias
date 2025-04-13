package com.courses.business.transactions;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;

import com.courses.models.Cuenta;
import com.courses.utils.Utils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DebitoTransactions {

    private final PlatformTransactionManager transactionManager;

    public void transferencias(Cuenta cuentaOrigen, 
        Cuenta cuentaDestino, BigDecimal monto) {
        
        BigDecimal comision = Utils.getComision(monto);
        
        cuentaOrigen.getAmount().subtract(monto.add(comision));
        cuentaDestino.getAmount().add(monto);

        

    }

}
