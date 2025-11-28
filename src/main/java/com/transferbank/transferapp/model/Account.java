package com.transferbank.transferapp.model;

import com.transferbank.transferapp.exception.LowBalanceAmountException;
import com.transferbank.transferapp.exception.NotValueAmountExcpetion;
import jakarta.persistence.*;

@Entity
@Table(name = "tbl_account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_number")
    private Integer number;
    @Column(name = "account_balance")
    private Double balance;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getBalance() {
        return balance;
    }

    public void withdraw(Double amount) {
        if (this.balance < amount){
            throw new LowBalanceAmountException("Não foi possível concluir a operação, saldo em conta é menor que o saldo debitado.");
        }
        if (amount <= 0){
            throw new NotValueAmountExcpetion("Não foi possível concluir a operação, valor atribuido ["+amount+"] é menor ou igual a zero.");
        }
        this.balance -= amount;
    }

    public void deposit(Double amount){
        if (amount <= 0){
            throw new NotValueAmountExcpetion("Não foi possível concluir a operação, valor atribuido ["+amount+"] é menor ou igual a zero.");
        }
        this.balance += amount;
    }
}
