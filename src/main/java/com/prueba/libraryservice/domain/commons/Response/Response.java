package com.prueba.libraryservice.domain.commons.Response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class Response <T>{

    private LocalDateTime timestamp;
    private String message;
    private int statusCode;
    private T data;

    public Response( String message, int statusCode, T data){

        this.timestamp = LocalDateTime.now();
        this.message = message;
        this.statusCode = statusCode;
        this.data = data;
    }

}
