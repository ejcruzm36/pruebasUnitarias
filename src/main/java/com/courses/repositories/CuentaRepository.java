package com.courses.repositories;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.courses.models.Cuenta;

@Component
public class CuentaRepository implements ICuentaRepository {

    private List<Cuenta> createCuentas() {
        Cuenta cuentaUno = Cuenta.builder()
                .name("Cuenta Uno")
                .amount(new BigDecimal(10200))
                .accountNumber("111111111")
                .build();
        Cuenta cuentaDos = Cuenta.builder()
                .name("Cuenta Dos")
                .amount(new BigDecimal(3500))
                .accountNumber("222222222")
                .build();
        Cuenta cuentaTres = Cuenta.builder()
                .name("Cuenta Tres")
                .amount(new BigDecimal(5000))
                .accountNumber("333333333")
                .build();
        Cuenta cuentaCuatro = Cuenta.builder()
                .name("Cuenta Cuatro")
                .amount(new BigDecimal(10000))
                .accountNumber("444444444")
                .build();

        List<Cuenta> cuentas = List.of(cuentaUno, cuentaDos, cuentaTres, cuentaCuatro);

        return cuentas;
    }

    @Override
    public Optional<List<Cuenta>> getCuentas(String accountNumber) {
        
        List<Cuenta> cuentas = createCuentas();

        Optional<List<Cuenta>> result = Optional.of(cuentas);
        
        return result;
    }

    @Override
    public Optional<Cuenta> getCuenta(String accountNumber) {
        
        List<Cuenta> cuentas = createCuentas();
        Optional<Cuenta> result = cuentas.stream()
                .filter(cuenta -> cuenta.getAccountNumber().equals(accountNumber))
                .findFirst();

        return result;
    }


}
