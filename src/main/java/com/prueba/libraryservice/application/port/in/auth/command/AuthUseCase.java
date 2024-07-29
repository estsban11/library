package com.prueba.libraryservice.application.port.in.auth.command;

import com.prueba.libraryservice.domain.entities.CredentialEntity;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthUseCase {

    CredentialEntity getToken(String username, String password);
}
