package com.transferbank.transferapp.controller;

import com.transferbank.transferapp.dto.TransactionDTO;
import com.transferbank.transferapp.model.Account;
import com.transferbank.transferapp.model.Transaction;
import com.transferbank.transferapp.service.IAccountService;
import com.transferbank.transferapp.service.ITransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class TransactionController {

    private final ITransactionService transactionService;
    private final IAccountService accountService;

    public TransactionController(ITransactionService transactionService, IAccountService accountService){
        this.transactionService = transactionService;
        this.accountService = accountService;
    }

    @GetMapping("/transaction/{id}")
    public ResponseEntity<Transaction> findTransactionById(@PathVariable Integer id){
        return ResponseEntity.ok().body(transactionService.findTransactionById(id));
    }

    @GetMapping("/transaction")
    public ResponseEntity<List<Transaction>> findAllTransactions(){
        return ResponseEntity.ok().body(transactionService.findAllTransactions());
    }

    @PostMapping("/transaction")
    public ResponseEntity<Transaction> addNewTransaction(@RequestBody TransactionDTO transaction){
        return ResponseEntity.status(201).body(transactionService.addNewTransaction(transaction));
    }
}
