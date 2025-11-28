package com.transferbank.transferapp.exception;

public class LowBalanceAmountException extends RuntimeException {
    public LowBalanceAmountException(String message) {
        super(message);
    }
}
