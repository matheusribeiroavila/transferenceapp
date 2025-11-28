package com.transferbank.transferapp.service;

import com.transferbank.transferapp.exception.NotFoundException;
import com.transferbank.transferapp.model.Account;
import com.transferbank.transferapp.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService{

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public Account addNewAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account findAccountById(Integer id) {
        return accountRepository.findById(id).orElseThrow(() -> new NotFoundException("Account ID ["+id+"] not found"));
    }

    @Override
    public List<Account> findAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account debitAmountFromAccount(Integer accountTargetId, Double amount) {
        Account accountTarget = accountRepository.findById(accountTargetId).orElseThrow(() -> new NotFoundException("Não foi possível completar operação de debito. Conta número ["+accountTargetId+"] não encontrado."));
        accountTarget.withdraw(amount);
        return accountRepository.save(accountTarget);
    }

    @Override
    public Account creditAmountFromAccount(Integer accountTargetId, Double amount) {
        Account accountTarget = accountRepository.findById(accountTargetId).orElseThrow(() -> new NotFoundException("Não foi possível completar operação de crédito. Conta número ["+accountTargetId+"] não encontrado."));
        accountTarget.deposit(amount);
        return accountRepository.save(accountTarget);
    }
}
