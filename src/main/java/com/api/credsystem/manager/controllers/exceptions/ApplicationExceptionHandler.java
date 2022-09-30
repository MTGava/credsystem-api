package com.api.credsystem.manager.controllers.exceptions;

import com.api.credsystem.manager.dtos.DefaultError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleException(RuntimeException e) {

        DefaultError error = new DefaultError(HttpStatus.BAD_REQUEST.value(), e.getMessage());

        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }
}
