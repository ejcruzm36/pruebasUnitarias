package com.courses.repositories;

import java.util.List;
import java.util.Optional;

import com.courses.models.Cuenta;

public interface ICuentaRepository {

    Optional<List<Cuenta>> getCuentas(String accountNumber);

    Optional<Cuenta> getCuenta(String accountNumber);
    
}
