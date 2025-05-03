package com.courses.models;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Credito {

    private String id;
    private String type;
    private BigDecimal amount;
    private BigDecimal amountTotal;
    private BigDecimal cout;
    private Integer months;
    private Cuenta account;


}
