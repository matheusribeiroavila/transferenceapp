package com.transferbank.transferapp.service;

import com.transferbank.transferapp.model.Account;

import java.util.List;

public interface IAccountService {
    public Account addNewAccount(Account account);
    public Account findAccountById(Integer id);
    public List<Account> findAllAccounts();

    public Account debitAmountFromAccount(Integer accountTargetId, Double amount);
    public Account creditAmountFromAccount(Integer accountTargetId, Double amount);

}
