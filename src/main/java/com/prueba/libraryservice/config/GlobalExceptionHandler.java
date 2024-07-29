package com.prueba.libraryservice.config;

import com.prueba.libraryservice.domain.commons.Response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Response<String>> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
        Response<String > errorDetails = new Response<>( ex.getMessage(), HttpStatus.BAD_REQUEST.value(), "");
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response<String >> handleGlobalException(Exception ex, WebRequest request) {
        Response<String> errorDetails = new Response<>( ex.getMessage(),  HttpStatus.INTERNAL_SERVER_ERROR.value(),"");
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
