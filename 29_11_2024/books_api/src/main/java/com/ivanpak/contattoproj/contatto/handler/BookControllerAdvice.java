package com.ivanpak.contattoproj.contatto.handler;

import com.ivanpak.contattoproj.contatto.exception.NoDataFoundException;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.HashMap;

// @Hidden
@ControllerAdvice // (basePackages = "com.ivanpak.contattoproj.contatto.controller")
public class BookControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Object> noDataFoundExceptionHandler(NoDataFoundException e) {
        HashMap<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("code_error", "1000");
        body.put("message", "Dato inesistente");
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        HashMap<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("code_error", "1001");
        body.put("message", e.getAllErrors());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}