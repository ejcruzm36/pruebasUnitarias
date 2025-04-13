package com.courses.services;

import org.springframework.stereotype.Service;

import com.courses.repositories.ICuentaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransferenciaService {

    private final ICuentaRepository cuentaRepository;

    
    

}
