package com.transferbank.transferapp.repository;

import com.transferbank.transferapp.model.Transaction;
import org.springframework.data.repository.ListCrudRepository;

public interface TransactionRepository extends ListCrudRepository<Transaction, Integer> {
}
