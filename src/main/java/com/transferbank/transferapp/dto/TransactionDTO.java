package com.transferbank.transferapp.dto;

import com.transferbank.transferapp.model.Account;

public record TransactionDTO(Integer debitAccountNumber, Integer creditAccountNumber, Double amount) {
}
