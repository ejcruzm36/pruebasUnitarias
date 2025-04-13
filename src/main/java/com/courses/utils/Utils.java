package com.courses.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Utils {

    public static BigDecimal getComision(BigDecimal amount){

        BigDecimal comision = BigDecimal.ZERO;
        
        if (amount.compareTo(new BigDecimal(Constants.MONTO_MINIMO)) >= 0) {
            comision = amount.multiply(new BigDecimal(Constants.COMISION));
        }

        comision = comision.setScale(2,RoundingMode.HALF_UP);

        return comision;

    }

}
