package com.courses.models;

import org.junit.jupiter.api.Test;

import com.courses.business.transactions.DebitoTransactions;
import com.courses.utils.Utils;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    @Test
    void testAccountName() {

        String nameEsperado = "John Doe"; 

        Cuenta cuenta = new Cuenta();
        cuenta.setName("John Doe");

        // assertEquals(nameEsperado, cuenta.getName());
        assertTrue(cuenta.getName().equals(nameEsperado)); 

    }

    @Test
    void testSaldoCuenta(){
        BigDecimal saldoEsperado = new BigDecimal(10);

        Cuenta cuenta = new Cuenta();
        cuenta.setAmount(new BigDecimal("1000"));

        assertTrue(cuenta.getAmount()
            .compareTo(saldoEsperado.multiply(new BigDecimal("100"))) == 0); 
    }

    @Test
    void testCuenta(){
        Cuenta cuentaUno = Cuenta
            .builder()
            .name("John Doe")
            .accountNumber("123456789")
            .amount(new BigDecimal("1000"))
            .build();
        Cuenta cuentaDos = Cuenta
            .builder()
            .name("John Doe")
            .accountNumber("123456789")
            .amount(new BigDecimal("1000"))
            .build();

        assertEquals(cuentaDos, cuentaUno); // vease Nota 01
        
    }

    @Test
    void testTransaction(){
        Cuenta cuenta = Cuenta.builder()
            .name("Usuario 1")
            .accountNumber("123456789")
            .amount(new BigDecimal("10000"))
            .build();
        Cuenta cuentaDos = Cuenta.builder()
            .name("Usuario 2")
            .accountNumber("987654321")
            .amount(new BigDecimal("200"))
            .build();

        BigDecimal montoTransferido = new BigDecimal(1000);
        BigDecimal saldoEsperadoUno = new BigDecimal("8950.00");
        BigDecimal saldoEsperadoDos = new BigDecimal("1200.00");
        
        BigDecimal comision = Utils.getComision(montoTransferido);
        assertNotNull(comision);
        
        DebitoTransactions debitoTransactions = new DebitoTransactions();
        debitoTransactions.transferencias(cuenta, cuentaDos, montoTransferido);
        
        assertNotNull(cuenta);
        assertNotNull(cuentaDos);

        assertEquals(saldoEsperadoUno, cuenta.getAmount());
        assertEquals(saldoEsperadoDos, cuentaDos.getAmount());

        
    }


}
