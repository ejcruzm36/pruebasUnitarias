package com.courses.business.credits;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.courses.enums.CreditEnum;
import com.courses.exceptions.BadRequestException;
import com.courses.exceptions.NotFoundException;
import com.courses.models.Credito;
import com.courses.utils.Constants;

@Service
public class CreditCalculator {

    public BigDecimal setCreditToClient(BigDecimal amount, String type, Integer term, Credito credito) {

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new BadRequestException("El monto debe ser mayor a cero");
        }

        BigDecimal interes = this.getInteres(type);
        BigDecimal totalPago = amount.add(amount.multiply(interes));

        if (Objects.isNull(credito.getAccount())) {
            throw new NotFoundException("La cuenta no existe");
        }

        credito.getAccount().setAmount(credito.getAccount().getAmount().add(amount));
        return totalPago;
    }

    public BigDecimal calculateCout(BigDecimal totalPago, Integer term) {
        return totalPago.divide(new BigDecimal(term), 2, RoundingMode.HALF_UP);
    }

    public BigDecimal getInteres(String type){
        switch (type) {
            case Constants.TYPE_HIPOTECARIA:
                return new BigDecimal(CreditEnum.HIPOTECA.getCup());
            case Constants.TYPE_PERSONAL:
                return new BigDecimal(CreditEnum.PERSONAL.getCup());
            case Constants.TYPE_VEHICULAR:
                return new BigDecimal(CreditEnum.VEHICULO.getCup());
            default:
                return BigDecimal.ZERO;
        }
    }



}
