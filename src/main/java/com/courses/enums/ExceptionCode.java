package com.courses.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionCode {

    AMOUNT_INSUFICIENT("Saldo insuficiente"),
    NULL_AMOUNT("Las cuentas no pueden ser nulas");

    private final String message;

}
