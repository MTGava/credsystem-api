package com.api.credsystem.manager.controllers;

import com.api.credsystem.manager.dtos.TransactionDto;
import com.api.credsystem.manager.models.TransactionModel;
import com.api.credsystem.manager.services.TransactionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@RequestMapping("/transacao")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<TransactionModel> save(@RequestBody @Valid TransactionDto transactionDto) {
        var transaction = new TransactionModel();
        BeanUtils.copyProperties(transactionDto, transaction);
        transaction.setDtTransacao(LocalDateTime.now(ZoneId.of("GMT-3")));
        return new ResponseEntity<>(transactionService.save(transaction, transactionDto.getCartao()), HttpStatus.CREATED);
    }
}
