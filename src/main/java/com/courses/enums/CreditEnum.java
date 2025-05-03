package com.courses.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CreditEnum {

    HIPOTECA("H", "Hipotecaria", "0.3"),
    PERSONAL("P", "Personal", "0.2"),
    VEHICULO("V", "Vehiculo", "0.25");

    private final String code;
    private final String message;
    private final String cup;

}
