package com.prueba.libraryservice.application.service;

import com.prueba.libraryservice.adapter.out.persistence.Credential;
import com.prueba.libraryservice.application.port.in.auth.command.AuthUseCase;
import com.prueba.libraryservice.config.jwt.JWTService;
import com.prueba.libraryservice.domain.entities.CredentialEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class AuthCommandService implements AuthUseCase {

    private  final AuthenticationManager authenticationManager;
    private final JWTService jwtService;
    private  final Credential credential;
    private final BCryptPasswordEncoder encoder;

    public AuthCommandService(AuthenticationManager authenticationManager, JWTService jwtService, Credential credential, BCryptPasswordEncoder encoder) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.credential = credential;
        this.encoder = encoder;
    }

    @Override
    public CredentialEntity getToken(String username, String password) {


        if(credential.findByUsername("root") == null) {
            CredentialEntity credentialEntity = new CredentialEntity("root", encoder.encode("root"), "", "estsban11");
            credential.save(credentialEntity);
        }

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username,password));
        UserDetails user = credential.findByUsername("root");

        System.out.println(user.getPassword());

        CredentialEntity newUser = (CredentialEntity) user;
        String token = jwtService.getToken(user);
        newUser.setJWT(token);
        return newUser;
    }
}
