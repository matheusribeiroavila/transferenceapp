package com.transferbank.transferapp.controller;

import com.transferbank.transferapp.dto.ErrorDTO;
import com.transferbank.transferapp.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionController{
    @ExceptionHandler(exception = NotFoundException.class)
    public ResponseEntity<ErrorDTO> handleNotFoundException(NotFoundException exception){
        return ResponseEntity.status(404).body(new ErrorDTO(exception.getMessage()));
    }
}
