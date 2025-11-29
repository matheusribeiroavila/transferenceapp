package com.transferbank.transferapp.service;

import com.transferbank.transferapp.dto.TransactionDTO;
import com.transferbank.transferapp.model.Transaction;

import java.util.List;

public interface ITransactionService {
    public Transaction addNewTransaction(TransactionDTO transaction);
    public Transaction findTransactionById(Integer transactionId);
    public List<Transaction> findAllTransactions();
}
