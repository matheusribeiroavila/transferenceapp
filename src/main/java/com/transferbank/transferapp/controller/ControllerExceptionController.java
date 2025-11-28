package com.transferbank.transferapp.controller;

import com.transferbank.transferapp.dto.ErrorDTO;
import com.transferbank.transferapp.exception.LowBalanceAmountException;
import com.transferbank.transferapp.exception.NotFoundException;
import com.transferbank.transferapp.exception.NotValueAmountExcpetion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionController{
    @ExceptionHandler(exception = NotFoundException.class)
    public ResponseEntity<ErrorDTO> handleNotFoundException(NotFoundException exception){
        return ResponseEntity.status(404).body(new ErrorDTO(exception.getMessage()));
    }

    @ExceptionHandler(exception = LowBalanceAmountException.class)
    public ResponseEntity<ErrorDTO> handleLowBalanceAmountException(LowBalanceAmountException exception){
        return ResponseEntity.badRequest().body(new ErrorDTO(exception.getMessage()));
    }

    @ExceptionHandler(exception = NotValueAmountExcpetion.class)
    public ResponseEntity<ErrorDTO> handlenNotValueAmountExcpetion(NotValueAmountExcpetion excpetion){
        return ResponseEntity.badRequest().body(new ErrorDTO(excpetion.getMessage()));
    }
}
