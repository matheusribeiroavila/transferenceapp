package com.transferbank.transferapp.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_number")
    private Integer number;
    @Column(name = "transaction_timestamp", nullable = true)
    private LocalDateTime timestamp;
    @Column(name = "transaction_amount")
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "transaction_debit_account")
    private Account debitAccount;

    @ManyToOne
    @JoinColumn(name = "transaction_credit_account")
    private Account creditAccount;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Account getDebitAccount() {
        return debitAccount;
    }

    public void setDebitAccount(Account debitAccount) {
        this.debitAccount = debitAccount;
    }

    public Account getCreditAccount() {
        return creditAccount;
    }

    public void setCreditAccount(Account creditAccount) {
        this.creditAccount = creditAccount;
    }
}
