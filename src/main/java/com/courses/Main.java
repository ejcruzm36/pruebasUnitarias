package com.courses;

import java.math.BigDecimal;

import com.courses.models.Cuenta;

public class Main {
    public static void main(String[] args) {
        
        Cuenta cuenta = new Cuenta();
        cuenta.setName("John Doe");
        cuenta.setAmount(new BigDecimal("1000.00"));
        cuenta.setAccountNumber("1234567890");

        System.out.println(cuenta.toString());


    }
}