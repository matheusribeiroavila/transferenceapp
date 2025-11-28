package com.transferbank.transferapp.service;

import com.transferbank.transferapp.exception.NotFoundException;
import com.transferbank.transferapp.model.Account;
import com.transferbank.transferapp.model.Transaction;
import com.transferbank.transferapp.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

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
    public Transaction addNewTransaction(Transaction transaction) {

        //Debitando e creditando as contas targets
        Account accountDebitedTarget = accountService.debitAmountFromAccount(transaction.getDebitAccount().getNumber(), transaction.getAmount());
        Account accountCreditTarget = accountService.creditAmountFromAccount(transaction.getCreditAccount().getNumber(), transaction.getAmount());

        //Preenchendo dados atualizados na transação
        transaction.setDebitAccount(accountDebitedTarget);
        transaction.setCreditAccount(accountCreditTarget);

        return transactionRepository.save(transaction);
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
