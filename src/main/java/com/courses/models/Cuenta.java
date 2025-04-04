package com.courses.models;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Cuenta {

    private String name;
    private BigDecimal amount;
    private String accountNumber;

}
