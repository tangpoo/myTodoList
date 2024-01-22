package com.sparta.mytodolist.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ NotMatchIdException.class })
    protected ResponseEntity handleIdException(NotMatchIdException ex){
        return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ DiffPasswordException.class })
    protected ResponseEntity handlePasswordException(DiffPasswordException ex){
        return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
