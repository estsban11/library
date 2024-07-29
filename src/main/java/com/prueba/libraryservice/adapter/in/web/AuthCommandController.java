package com.prueba.libraryservice.adapter.in.web;

import com.prueba.libraryservice.application.port.in.auth.command.AuthUseCase;
import com.prueba.libraryservice.domain.commons.Response.Response;
import com.prueba.libraryservice.domain.entities.Author;
import com.prueba.libraryservice.domain.entities.CredentialEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthCommandController {

    private final AuthUseCase authUseCase;

    public AuthCommandController(AuthUseCase authUseCase) {
        this.authUseCase = authUseCase;
    }

    @GetMapping
    public ResponseEntity<Response<CredentialEntity>> getToken(){
        var credential = authUseCase.getToken("root","root");
        return new ResponseEntity<>(new Response<>(null, HttpStatus.OK.value(), credential),HttpStatus.OK);
    }
}
