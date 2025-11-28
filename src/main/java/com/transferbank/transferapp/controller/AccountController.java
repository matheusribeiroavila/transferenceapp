package com.transferbank.transferapp.controller;

import com.transferbank.transferapp.model.Account;
import com.transferbank.transferapp.service.IAccountService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController{

    private final IAccountService accountService;

    public AccountController(IAccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<Account> findAccountById(@PathVariable Integer id){
        return ResponseEntity.ok().body(accountService.findAccountById(id));
    }

    @GetMapping("/account")
    public ResponseEntity<List<Account>> findAllAccounts(){
        return ResponseEntity.ok().body(accountService.findAllAccounts());
    }

    @PostMapping("/account")
    public ResponseEntity<Account> addNewAccount(@RequestBody Account account){
        return ResponseEntity.status(201).body(accountService.addNewAccount(account));
    }

}
