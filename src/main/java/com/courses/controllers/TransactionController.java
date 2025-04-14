package com.courses.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.courses.services.TransferenciaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/trasaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransferenciaService transferenciaService;

    @GetMapping("/start")
    public ResponseEntity<String> startTransferencia() {

        transferenciaService.startTransferencia();

        return new ResponseEntity<String>("Transferencia exitosa", HttpStatus.OK);
    }


}
