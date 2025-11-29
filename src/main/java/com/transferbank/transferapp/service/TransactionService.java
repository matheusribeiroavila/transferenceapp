package com.transferbank.transferapp.service;

import com.transferbank.transferapp.dto.TransactionDTO;
import com.transferbank.transferapp.exception.NotFoundException;
import com.transferbank.transferapp.model.Account;
import com.transferbank.transferapp.model.Transaction;
import com.transferbank.transferapp.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class TransactionService implements ITransactionService{

    private final TransactionRepository transactionRepository;
    private final IAccountService accountService;

    public TransactionService(TransactionRepository transactionRepository, IAccountService accountService){
        this.transactionRepository = transactionRepository;
        this.accountService = accountService;
    }

    @Override
    public Transaction addNewTransaction(TransactionDTO dto) {

        //Debitando e creditando as contas targets
        Account accountDebitedTarget = accountService.debitAmountFromAccount(dto.debitAccountNumber(), dto.amount());
        Account accountCreditTarget = accountService.creditAmountFromAccount(dto.creditAccountNumber(), dto.amount());

        //Construindo a entidade de transação
        Transaction transactionTarget = new Transaction();
        transactionTarget.setAmount(dto.amount());
        transactionTarget.setDebitAccount(accountDebitedTarget);
        transactionTarget.setCreditAccount(accountCreditTarget);
        transactionTarget.setTimestamp(LocalDateTime.now());

        return transactionRepository.save(transactionTarget);
    }

    @Override
    public Transaction findTransactionById(Integer transactionId) {
        return transactionRepository.findById(transactionId).orElseThrow(() -> new NotFoundException("Transação número ["+transactionId+"] não encontrada"));
    }

    @Override
    public List<Transaction> findAllTransactions() {
        return transactionRepository.findAll();
    }
}
