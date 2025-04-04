package com.courses.models;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

class CuentaTest {

    @Test
    void testAccountName() {

        String nameEsperado = "John Doe"; 

        Cuenta cuenta = new Cuenta();
        cuenta.setName("John Doe");

        Assertions.assertEquals(nameEsperado, cuenta.getName());

    }

}
