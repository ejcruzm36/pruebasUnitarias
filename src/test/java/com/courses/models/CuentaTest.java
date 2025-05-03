package com.courses.models;

import org.junit.jupiter.api.Test;

import com.courses.business.transactions.DebitoTransactions;
import com.courses.enums.ExceptionCode;
import com.courses.exceptions.NotFoundException;
import com.courses.utils.Utils;

import java.math.BigDecimal;
import java.util.ArrayList;

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
        BigDecimal saldoEsperadoDos = new BigDecimal(1200.00);
        
        BigDecimal comision = Utils.getComision(montoTransferido);
        assertNotNull(comision);
        
        DebitoTransactions debitoTransactions = new DebitoTransactions();
        debitoTransactions.transferencias(cuenta, cuentaDos, montoTransferido);
        
        assertNotNull(cuenta);
        assertNotNull(cuentaDos);

        assertEquals(saldoEsperadoUno, cuenta.getAmount());
        assertEquals(saldoEsperadoDos, cuentaDos.getAmount());

        
    }

    @Test
    void testExceptions(){

        DebitoTransactions debitoTransactions = new DebitoTransactions();

        Cuenta cuentaUno = null;
        Cuenta cuentaDos = Cuenta.builder()
            .name("Usuario 2")
            .accountNumber("987654321")
            .amount(new BigDecimal("200"))
            .build();

        BigDecimal amount = new BigDecimal("1000");

        Exception exception = assertThrows(NotFoundException.class, () -> {
            debitoTransactions.transferencias(cuentaUno, cuentaDos, amount);
        });

        String expectedMessage = ExceptionCode.NULL_AMOUNT.getMessage();
        String actualMessage = exception.getMessage();
        // assertTrue(actualMessage.equals(expectedMessage));
        assertEquals(expectedMessage, actualMessage);

    }

    @Test
    void testRelations(){
        Cuenta cuenta1 = Cuenta.builder()
            .name("Usuario 1")
            .accountNumber("123456789")
            .amount(new BigDecimal("10000"))
            .build();
        Cuenta cuenta2 = Cuenta.builder()
            .name("Usuario 2")
            .accountNumber("987654321")
            .amount(new BigDecimal("200"))
            .build();

        Banco banco = Banco.builder()
            .name("Banco 1")
            .address("Direccion 1")
            .cuentas(new ArrayList<>())
            .build();

        banco.addCuenta(cuenta1);
        banco.addCuenta(cuenta2);

        assertAll(
            () -> assertEquals(2, banco.getCuentas().size()),
            () -> assertEquals("Banco 1", cuenta1.getBanco().getName()),
            () -> assertEquals("Usuario 1", banco.getCuentas().stream()
                    .filter(c -> c.getName().equals("Usuario 1"))
                    .findFirst()
                    .orElseThrow(() -> new NotFoundException("Cuenta no encontrada"))
                    .getName()),

            () -> assertThrows(NotFoundException.class, () -> {
                    banco.getCuentas().stream()
                        .filter(c -> c.getName().equals("Usuario 3"))
                        .findFirst()
                        .orElseThrow(() -> new NotFoundException("Cuenta no encontrada"));
            })


        );

    }


}
