package com.courses.controllers;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.courses.models.Credito;
import com.courses.services.CreditoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/credit")
@RequiredArgsConstructor
public class CreditoController {

    private final CreditoService creditoService;

    @GetMapping("/start")
    public ResponseEntity<Credito> startTransferencia() {

        Credito credito = creditoService.getCredito(new BigDecimal(1000), "V", 24);

        return new ResponseEntity<>(credito, HttpStatus.OK);
    }

}
