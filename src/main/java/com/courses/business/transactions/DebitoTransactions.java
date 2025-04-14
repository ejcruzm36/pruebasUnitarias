package com.courses.business.transactions;

import java.math.BigDecimal;
import java.util.Objects;

import org.springframework.stereotype.Service;
// import org.springframework.transaction.PlatformTransactionManager;

import com.courses.exceptions.BadRequestException;
import com.courses.exceptions.NotFoundException;
import com.courses.models.Cuenta;
import com.courses.utils.Utils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DebitoTransactions {

    // private final PlatformTransactionManager transactionManager;

    public void transferencias(Cuenta cuentaOrigen, 
        Cuenta cuentaDestino, BigDecimal monto) {

        if (Objects.isNull(cuentaOrigen) || 
            Objects.isNull(cuentaDestino)) {
            throw new NotFoundException("Las cuentas no pueden ser nulas");
        }
        
        BigDecimal comision = Utils.getComision(monto);
        
        cuentaOrigen.setAmount(cuentaOrigen.getAmount()
            .subtract(monto.add(comision)));
        cuentaDestino.setAmount(cuentaDestino.getAmount()
            .add(monto));  
            
    }

}
