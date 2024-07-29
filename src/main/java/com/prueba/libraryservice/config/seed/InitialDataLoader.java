package com.prueba.libraryservice.config.seed;

import com.prueba.libraryservice.adapter.out.persistence.Credential;
import com.prueba.libraryservice.config.jwt.JWTService;
import com.prueba.libraryservice.domain.entities.CredentialEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class InitialDataLoader implements CommandLineRunner {

    private final Credential credential;

    public InitialDataLoader(Credential credential) {
        this.credential = credential;
    }

    @Override
    public void run(String... args) throws Exception {

    }

    private void InitialData(){



    }
}
